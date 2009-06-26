#include "drawing.h"
#include <cstdlib>
#include <iostream>
#include <cstdio>
#include <cmath>

using namespace Pineapple;

int circle_precision = 24;

/* Low-level drawing stuffles */

void Drawing::drawBegin(GLenum mode) {
    glBegin(mode);
}

void Drawing::drawEnd(void) {
    glEnd();
}

void Drawing::drawVertex(GLdouble x, GLdouble y, GLdouble z, GLdouble w) {
    glVertex4d(x, y, z, w);
}

void Drawing::drawTranslate(GLdouble x, GLdouble y, GLdouble z) {
    glTranslated(x, y, z);
}

void Drawing::drawPush() {
    glPushMatrix();
}

void Drawing::drawPop() {
    glPopMatrix();
}

/* Color stuffles */

Pineapple::Color* Drawing::drawColor() {
    GLfloat* f = new GLfloat[4];
    glGetFloatv(GL_CURRENT_COLOR, f);
    return new Pineapple::Color(f[0], f[1], f[2], f[3]);
}

void Drawing::drawColor(Pineapple::Color* c) {
    glColor4f(c->getRed(), c->getGreen(), c->getBlue(), c->getAlpha());
}

void Drawing::drawColor(Pineapple::Color* c, GLfloat a) {
    glColor4f(c->getRed(), c->getGreen(), c->getBlue(), a);
}

void Drawing::drawColor(GLfloat r, GLfloat g, GLfloat b) {
    glColor3f(r, g, b);
}
void Drawing::drawColor(GLfloat r, GLfloat g, GLfloat b, GLfloat a) {
    glColor4f(r, g, b, a);
}


/* Simple Shapes */
void Drawing::drawCircle(GLdouble x,GLdouble y, GLdouble r, bool filled) {
    drawBegin((filled) ? DRAW_POLYGON : DRAW_LINE_LOOP);
    for (float a = 0; a < M_PI * 2; a += M_PI*2/(Math::abs(r)*4))//  Circumference of circle = 2PI * r
    {
        drawVertex(x + sin(a) * r, y + cos(a) * r);
    }
    drawEnd();
}

void Drawing::drawLine(GLdouble x1,GLdouble y1, GLdouble x2, GLdouble y2) {
    drawBegin(DRAW_LINES);
    drawVertex(x1, y1);
    drawVertex(x2, y2);
    drawEnd();
}

void Drawing::drawRectangle(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, bool filled)
{
    drawBegin((filled) ? DRAW_QUADS : DRAW_LINE_LOOP);
    drawVertex(x1, y1);
    drawVertex(x2, y1);
    drawVertex(x2, y2);
    drawVertex(x1, y2);
    drawEnd();
}

void Drawing::drawRectangle(Rectangle* r, bool filled)
{
    drawRectangle(r->p1->getX(), r->p1->getY(), r->p2->getX(), r->p2->getY(), filled);
}

void Drawing::drawPoint(GLdouble x, GLdouble y)
{
    drawBegin(DRAW_POINTS);
    drawVertex(x, y);
    drawEnd();
}

void Drawing::drawPoint(Point* p)
{
    drawPoint(p->getX(), p->getY());
}

// Borrowed from ENIGMA
void Drawing::drawEllipse(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, bool filled)
{
  double x = (x1+x2)/2;
  double y = (y1+y2)/2;
  double hr = fabs(x2-x);
  double vr = fabs(y2-y);

  if (filled)
  {
    drawBegin(DRAW_TRIANGLE_FAN);
    drawVertex(x,y);
  }
  else
    drawBegin(DRAW_LINE_STRIP);

  for (int i = 0; i <= circle_precision; i++)
  {
    drawVertex(x + hr * cos(2 * M_PI * i/circle_precision), y + vr * sin(2 * M_PI * i/circle_precision ));
  }
  drawEnd();
}


// Borrowed from ENIGMA
void Drawing::drawRoundRect(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, bool filled)
{
    double hr = (x2-x1)/2.0; if (hr<4) hr=4;
    double vr = (y2-y1)/2.0; if (vr<4) vr=4;

    double precision = (int)(circle_precision/4.0+0.5);

    int i;
    double xx,yy;

    if (!filled)
    {
       drawBegin(GL_LINE_STRIP);
       //right side
       drawVertex(x2,y2-vr);
       drawVertex(x2,y1+vr);
       //topright corner
       for (i=1;i<precision;i+=1)
       {
           xx = x2-hr+hr*cos(-(i/precision)*0.5*M_PI);
           yy = y1+vr+vr*sin(-(i/precision)*0.5*M_PI);
           drawVertex(xx,yy);
       }
      //top side
      drawVertex(x2-hr,y1);
      drawVertex(x1+hr,y1);
      //topleft corner
      for (i=1;i<precision;i+=1)
      {
          xx = x1+hr+hr*cos(-(i/precision+1)*0.5*M_PI);
          yy = y1+vr+vr*sin(-(i/precision+1)*0.5*M_PI);
          drawVertex(xx,yy);
      }
      //left side
      drawVertex(x1,y1+vr);
      drawVertex(x1,y2-vr);
      //bottomleft corner
      for (i=1;i<precision;i+=1)
      {
          xx = x1+hr+hr*cos(-(i/precision+2)*0.5*M_PI);
          yy = y2-vr+vr*sin(-(i/precision+2)*0.5*M_PI);
          drawVertex(xx,yy);
      }
      //bottom side
      drawVertex(x1+hr,y2);
      drawVertex(x2-hr,y2);
      //bottomright corner
      for (i=1;i<=precision;i+=1)
      {
          xx = x2-hr+hr*cos(-(i/precision+3)*0.5*M_PI);
          yy = y2-vr+vr*sin(-(i/precision+3)*0.5*M_PI);
          drawVertex(xx,yy);
      }
      drawEnd();
    }
    else
    {
        drawBegin(GL_TRIANGLES);
        //middle part
        drawVertex(x1+hr,y1+vr);
        drawVertex(x2-hr,y1+vr);
        drawVertex(x1+hr,y2-vr);

        drawVertex(x2-hr,y1+vr);
        drawVertex(x1+hr,y2-vr);
        drawVertex(x2-hr,y2-vr);
        //the other parts
        drawVertex(x1,y1+vr);
        drawVertex(x1+hr,y1+vr);
        drawVertex(x1,y2-vr);

        drawVertex(x1+hr,y1+vr);
        drawVertex(x1,y2-vr);
        drawVertex(x1+hr,y2-vr);

        drawVertex(x2,y1+vr);
        drawVertex(x2-hr,y1+vr);
        drawVertex(x2,y2-vr);

        drawVertex(x2-hr,y1+vr);
        drawVertex(x2,y2-vr);
        drawVertex(x2-hr,y2-vr);

        drawVertex(x1+hr,y1);
        drawVertex(x1+hr,y1+vr);
        drawVertex(x2-hr,y1);

        drawVertex(x1+hr,y1+vr);
        drawVertex(x2-hr,y1);
        drawVertex(x2-hr,y1+vr);

        drawVertex(x1+hr,y2);
        drawVertex(x1+hr,y2-vr);
        drawVertex(x2-hr,y2);

        drawVertex(x1+hr,y2-vr);
        drawVertex(x2-hr,y2);
        drawVertex(x2-hr,y2-vr);
        //topright corner
        for (i=0;i<precision;i+=1)
        {
            drawVertex(x2-hr,y1+vr);
            xx = x2-hr+hr*cos(-(i/precision)*0.5*M_PI);
            yy = y1+vr+vr*sin(-(i/precision)*0.5*M_PI);
            drawVertex(xx,yy);
            xx = x2-hr+hr*cos(-((i+1)/precision)*0.5*M_PI);
            yy = y1+vr+vr*sin(-((i+1)/precision)*0.5*M_PI);
            drawVertex(xx,yy);
        }
        //topleft corner
        for (i=0;i<precision;i+=1)
        {
            drawVertex(x1+hr,y1+vr);
            xx = x1+hr+hr*cos(-(i/precision+1)*0.5*M_PI);
            yy = y1+vr+vr*sin(-(i/precision+1)*0.5*M_PI);
            drawVertex(xx,yy);
            xx = x1+hr+hr*cos(-((i+1)/precision+1)*0.5*M_PI);
            yy = y1+vr+vr*sin(-((i+1)/precision+1)*0.5*M_PI);
            drawVertex(xx,yy);
        }
        //bottomleft corner
        for (i=0;i<precision;i+=1)
        {
            drawVertex(x1+hr,y2-vr);
            xx = x1+hr+hr*cos(-(i/precision+2)*0.5*M_PI);
            yy = y2-vr+vr*sin(-(i/precision+2)*0.5*M_PI);
            drawVertex(xx,yy);
            xx = x1+hr+hr*cos(-((i+1)/precision+2)*0.5*M_PI);
            yy = y2-vr+vr*sin(-((i+1)/precision+2)*0.5*M_PI);
            drawVertex(xx,yy);
        }
        //bottomright corner
        for (i=0;i<precision;i+=1)
        {
            drawVertex(x2-hr,y2-vr);
            xx = x2-hr+hr*cos(-(i/precision+3)*0.5*M_PI);
            yy = y2-vr+vr*sin(-(i/precision+3)*0.5*M_PI);
            drawVertex(xx,yy);
            xx = x2-hr+hr*cos(-((i+1)/precision+3)*0.5*M_PI);
            yy = y2-vr+vr*sin(-((i+1)/precision+3)*0.5*M_PI);
            drawVertex(xx,yy);
        }
        drawEnd();
    }
}


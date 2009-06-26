#ifndef DRAWING_H_INCLUDED
#define DRAWING_H_INCLUDED

#include <math.h>
#include <SDL/SDL_opengl.h>
#include "color.h"

#define RAD2DEG 0.0174532925

#define DRAW_POINTS         GL_POINTS
#define DRAW_LINES          GL_LINES
#define DRAW_LINE_STRIP     GL_LINE_STRIP
#define DRAW_LINE_LOOP      GL_LINE_LOOP
#define DRAW_TRIANGLES      GL_TRIANGLES
#define DRAW_TRIANGLE_STRIP GL_TRIANGLE_STRIP
#define DRAW_TRIANGLE_FAN   GL_TRIANGLE_FAN
#define DRAW_QUADS          GL_QUADS
#define DRAW_QUAD_STRIP     GL_QUAD_STRIP
#define DRAW_POLYGON        GL_POLYGON


/* Low-level drawing stuffles */

namespace Pineapple
{
    class Drawing
    {
      public:
        void drawBegin(GLenum mode);
        void drawEnd(void);
        void drawVertex(GLdouble x, GLdouble y, GLdouble z = 0, GLdouble w = 1);
        void drawTranslate(GLdouble x, GLdouble y, GLdouble z = 0);
        void drawPush();
        void drawPop();

        /* Color stuffles */

        Pineapple::Color* drawColor();
        void drawColor(Pineapple::Color* c);
        void drawColor(Pineapple::Color* c, GLfloat a);
        void drawColor(GLfloat r, GLfloat g, GLfloat b);
        void drawColor(GLfloat r, GLfloat g, GLfloat b, GLfloat a);

        /* Simple Shapes */

        void drawCircle(GLdouble x,GLdouble y, GLdouble r, bool filled = true);
        void drawLine(GLdouble x1,GLdouble y1, GLdouble x2, GLdouble y2);
        void drawRectangle(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, bool filled = true);
        void drawRoundRect(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, bool filled = true);
        void drawEllipse(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, bool filled = true);
        void drawTriangle(GLdouble x1, GLdouble y1, GLdouble x2, GLdouble y2, GLdouble x3, GLdouble y3, bool filled = true);
        void drawPoint(GLdouble x, GLdouble y);
    };
}

#endif // DRAWING_H_INCLUDED

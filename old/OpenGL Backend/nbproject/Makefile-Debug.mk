#
# Gererated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=build/Debug/GNU-Linux-x86

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/actor.o \
	${OBJECTDIR}/dummy-interop.o \
	${OBJECTDIR}/view.o \
	${OBJECTDIR}/texture.o \
	${OBJECTDIR}/unix-interop.o \
	${OBJECTDIR}/window.o \
	${OBJECTDIR}/functionpointer.o \
	${OBJECTDIR}/pineapple.o \
	${OBJECTDIR}/drawingprimitives.o \
	${OBJECTDIR}/scene.o \
	${OBJECTDIR}/color.o \
	${OBJECTDIR}/math.o \
	${OBJECTDIR}/application.o

# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=-lSDL -lGL -lSDL_image -lGLU -lm

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS} dist/Debug/GNU-Linux-x86/opengl_backend

dist/Debug/GNU-Linux-x86/opengl_backend: ${OBJECTFILES}
	${MKDIR} -p dist/Debug/GNU-Linux-x86
	${LINK.cc} -o dist/Debug/GNU-Linux-x86/opengl_backend ${OBJECTFILES} ${LDLIBSOPTIONS} 

${OBJECTDIR}/actor.o: actor.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/actor.o actor.cpp

${OBJECTDIR}/dummy-interop.o: dummy-interop.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/dummy-interop.o dummy-interop.cpp

${OBJECTDIR}/view.o: view.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/view.o view.cpp

${OBJECTDIR}/texture.o: texture.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/texture.o texture.cpp

${OBJECTDIR}/unix-interop.o: unix-interop.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/unix-interop.o unix-interop.cpp

${OBJECTDIR}/window.o: window.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/window.o window.cpp

${OBJECTDIR}/functionpointer.o: functionpointer.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/functionpointer.o functionpointer.cpp

${OBJECTDIR}/pineapple.o: pineapple.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/pineapple.o pineapple.cpp

${OBJECTDIR}/drawingprimitives.o: drawingprimitives.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/drawingprimitives.o drawingprimitives.cpp

${OBJECTDIR}/scene.o: scene.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/scene.o scene.cpp

${OBJECTDIR}/color.o: color.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/color.o color.cpp

${OBJECTDIR}/math.o: math.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/math.o math.cpp

${OBJECTDIR}/application.o: application.cpp 
	${MKDIR} -p ${OBJECTDIR}
	$(COMPILE.cc) -g -D_DEBUG_ -I/usr/include/SDL -o ${OBJECTDIR}/application.o application.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf:
	${RM} -r build/Debug
	${RM} dist/Debug/GNU-Linux-x86/opengl_backend

# Subprojects
.clean-subprojects:

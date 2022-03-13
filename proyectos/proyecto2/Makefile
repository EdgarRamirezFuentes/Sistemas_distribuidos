# Este Makefile se encarga de generar las clases necesarias y ejecutarel proyecto.
# Edgar Alejandro Ramírez Fuentes
# Proyecto 2
# Grupo 4CM13

JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  Main.java \
		  Coordenada.java \
		  PoligonoIrreg.java \
		  PoligonoRegular.java
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
run:
	java Main 


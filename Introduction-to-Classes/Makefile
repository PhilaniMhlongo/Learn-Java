#Makefile
#Philani Mhlongo
#01/01/24
JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
DOCSDIR=docs

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES= Amount.class InsufficiebtFundsExceptions.class Account.class Transaction.class Main.class


CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

docs:
	javadoc -cp $(BINDIR) -d /docs/ /src/*.java
	
clean:
	rm $(BINDIR)/*.class
	
runMain: $(CLASS_FILES)
	java -cp $(BINDIR) Main

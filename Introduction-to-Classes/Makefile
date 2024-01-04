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
.PHONY: docs
docs: $(CLASS_FILES)
	javadoc -cp /home/philani/Github/Learn-Java/Introduction-to-Classes/bin/ -d /home/philani/Github/Learn-Java/Introduction-to-Classes/docs/ /home/philani/Github/Learn-Java/Introduction-to-Classes/src/*.java
clean:
	rm $(BINDIR)/*.class
	
runMain: $(CLASS_FILES)
	java -cp $(BINDIR) Main

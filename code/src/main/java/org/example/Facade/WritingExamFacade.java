package org.example.Facade;

/**
 * this is the facade pattern
 */
public class WritingExamFacade {

    RideBus gotoSchool;
    Enterclass enterClass;
    WriteExam submitExam;

    WritingExamFacade(RideBus school, Enterclass cl, WriteExam exam){
        this.gotoSchool = school;
        this.enterClass = cl;
        this.submitExam = exam;
    }

    public void completeExam(){
        this.gotoSchool.ride();
        this.enterClass.enter();
        this.submitExam.write();
    }
}

class RideBus {
    public void ride(){
        System.out.println("ride the bus");
    }
}

class Enterclass {
    public void enter(){
        System.out.println("enter class");
    }
}

class WriteExam {

    public void write(){
        System.out.println("write the exam");
    }
}

class Client{
    public static void main (String [] args){
        WritingExamFacade writeExam = new WritingExamFacade(new RideBus(),new Enterclass(), new WriteExam());
        writeExam.completeExam();
    }
}

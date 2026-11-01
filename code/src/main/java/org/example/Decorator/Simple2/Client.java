package org.example.Decorator.Simple2;

public class Client {
    public static void main (String [] args){
        Data data = new CloudData();
        Data compressedData = new CompressionDecorator(data);
        Data encyptedData = new EncryptionDecorator(compressedData);
        encyptedData.save();
    }
}

interface Data{
    public void save();
}

class CloudData implements Data{
    @Override
    public void save() {
        System.out.println("save data");
    }
}

class CompressionDecorator implements Data{
    Data data;
    CompressionDecorator(Data data){
        this.data = data;
    }
    @Override
    public void save() {
        System.out.println("compress data"); // unique feature
        this.data.save();
    }
}

class EncryptionDecorator implements Data{
    Data data;
    EncryptionDecorator(Data data){
        this.data = data;
    }
    @Override
    public void save() {
        System.out.println("encrypt data"); // unique feature
        this.data.save();
    }
}
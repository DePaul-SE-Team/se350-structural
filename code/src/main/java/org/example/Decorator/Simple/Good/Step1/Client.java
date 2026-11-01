package org.example.Decorator.Simple.Good.Step1;

public class Client {
}

// you have some object with some kind of feature,
// and you want to decorate that object with optional feature, then you should create an
// common interface and declare commonn feature there (the feature you want to decorate).
interface Pizza{
}

// everything starts with the wrappee
class PlainPizza{
}

class PepperoniWrapper{
}


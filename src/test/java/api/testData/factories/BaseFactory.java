package api.testData.factories;

import api.testData.generators.RandomCredentialsGenerator;


public abstract class BaseFactory {
    protected final RandomCredentialsGenerator generator;

    protected BaseFactory(RandomCredentialsGenerator generator) {
        this.generator = generator;
    }
}
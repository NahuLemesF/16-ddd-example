package com.twilightimperium.shared.application;

public interface ICommandUseCase<T extends Request, R> {
    R execute(T request);
}

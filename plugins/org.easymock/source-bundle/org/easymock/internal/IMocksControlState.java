/*
 * Copyright (c) 2001-2008 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal;

import org.easymock.IAnswer;

public interface IMocksControlState extends ILegacyMethods {

    Object invoke(Invocation invocation) throws Throwable;

    void assertRecordState();

    void andReturn(Object value);

    void andThrow(Throwable throwable);

    void andAnswer(IAnswer<?> answer);

    void andStubReturn(Object value);

    void andStubThrow(Throwable throwable);

    void andStubAnswer(IAnswer<?> answer);

    void asStub();

    void times(Range range);

    void checkOrder(boolean value);

    void makeThreadSafe(boolean threadSafe);
    
    void replay();

    void verify();
}

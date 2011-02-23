/*
 * Copyright (c) 2001-2008 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal;

import java.io.Serializable;

import org.easymock.IAnswer;

public class Result implements IAnswer<Object>, Serializable {

    private static final long serialVersionUID = 5476251941213917681L;
    
    private IAnswer<?> value;

    private Result(IAnswer<?> value) {
        this.value = value;
    }

    public static Result createThrowResult(final Throwable throwable) {
        class ThrowingAnswer implements IAnswer<Object>, Serializable {

            private static final long serialVersionUID = -332797751209289222L;

            public Object answer() throws Throwable {
                throw throwable;
            }

            @Override
            public String toString() {
                return "Answer throwing " + throwable;
            }
        }
        return new Result(new ThrowingAnswer());
    }

    public static Result createReturnResult(final Object value) {
        class ReturningAnswer implements IAnswer<Object>, Serializable {

            private static final long serialVersionUID = 6973893913593916866L;
            
            public Object answer() throws Throwable {
                return value;
            }
            
            @Override
            public String toString() {
                return "Answer returning " + value;
            }
        }
        return new Result(new ReturningAnswer());
    }

    public static Result createAnswerResult(IAnswer<?> answer) {
        return new Result(answer);
    }

    public Object answer() throws Throwable {
        return value.answer();
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
    
}

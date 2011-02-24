/*
 * Copyright (c) 2001-2008 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import java.io.Serializable;

import org.easymock.IArgumentMatcher;

public class Same implements IArgumentMatcher, Serializable {

    private static final long serialVersionUID = 1094930851962278376L;
    
    private final Object expected;

    public Same(Object expected) {
        this.expected = expected;
    }

    public boolean matches(Object actual) {
        return expected == actual;
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("same(");
        appendQuoting(buffer);
        buffer.append(expected);
        appendQuoting(buffer);
        buffer.append(")");
    }

    private void appendQuoting(StringBuffer buffer) {
        if (expected instanceof String) {
            buffer.append("\"");
        } else if (expected instanceof Character) {
            buffer.append("'");
        }
    }
}

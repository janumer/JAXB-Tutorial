package com.jaxb.generated;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.MockitoJUnit;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StatusTest {
@Test
    public void testStatusClass(){
    Status status = new Status();
    assertNull(status.getStatusIndex());
    assertEquals(0, status.getId());
    assertNull(status.getName());
}
}

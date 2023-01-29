package com.lintrip.java8;

import cn.hutool.core.lang.Assert;
import com.lintrip.java8.domain.MyList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author gyt
 * @date 2022/10/26 14:47
 */
@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Test
    public void test01(){
        MyList listMock = mock(MyList.class);
        when(listMock.add(anyString())).thenReturn(false);
        boolean added = listMock.add(randomAlphabetic(6));
        verify(listMock).add(anyString());
        Assert.isFalse(added);
    }
}

package guru.springframework.sfgpetclinic.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlexGenericTaskTest {

    @Mock
    IAlexGenericTask alexGenericTask;

    // Use doThrow() when you want to stub the void method with an exception.
    @Test
    void validateThrowException_1() {

        // Set condition when to throw exception. Mimic in Mockito
        // Use doThrow() when you want to stub the void method with an exception.
        doThrow(new RuntimeException("Properly Throw Exception in validateThrowException_1")).when(alexGenericTask).doAction(anyString());

        // should use lambda. Test that exeption is thrown
        assertThrows(RuntimeException.class, () -> alexGenericTask.doAction("data"));

        // Verify it has been thrown
        verify(alexGenericTask).doAction("data");
    }

    // BBD (bihavior driven development)
    // give => when => then
    @Test
    void validateThrowException_2() {

        // given
        given(alexGenericTask.retrieve(1L)).willThrow(new RuntimeException("Properly Throw Exception in validateThrowException_2"));

        // when
        assertThrows(RuntimeException.class, () -> alexGenericTask.retrieve(1L));

        // then
        then(alexGenericTask).should().retrieve(1L);
    }

    // BBD (bihavior driven development)
    // give => when => then
    @Test
    void validateThrowException_3() {

        // given
        BDDMockito.willThrow(new RuntimeException("Properly Throw Exception in validateThrowException_2")).given(alexGenericTask).retrieve(anyLong());

        // when
        assertThrows(RuntimeException.class, () -> alexGenericTask.retrieve(anyLong()));

        // then
        then(alexGenericTask).should().retrieve(anyLong());
    }





}
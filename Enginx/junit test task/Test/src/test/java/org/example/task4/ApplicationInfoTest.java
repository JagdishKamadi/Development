package org.example.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class ApplicationInfoTest {

    private ApplicationInfoRepository repository;
    private ApplicationInfo applicationInfo;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ApplicationInfoRepository.class);
        applicationInfo = new ApplicationInfo(repository);
    }

    @Test
    void testStore() {
        // Mocking system properties for the test
        System.setProperty("os.name", "TestOS");
        System.setProperty("user.dir", "TestDirectory");

        // Perform the store operation
        applicationInfo.store();

        // Verify that the save method of the repository was called with the correct argument
        // when
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(repository).save(argumentCaptor.capture());

        // Verify the captured argument against the expected value
        String expectedInfo = String.format("\n* Operating system: %s\n* Java version: %s\n* Working directory: %s",
                "TestOS", Runtime.version(), "TestDirectory");
        // then
        assertEquals(expectedInfo, argumentCaptor.getValue());
    }
}

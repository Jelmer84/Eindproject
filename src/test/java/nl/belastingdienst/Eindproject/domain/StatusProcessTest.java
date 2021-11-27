package nl.belastingdienst.Eindproject.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class StatusProcessTest {

    @Test
    void StatusProcess() {
        assertSame(StatusProcess.valueOf("InspectionPlanned"), StatusProcess.InspectionPlanned);
        assertSame(StatusProcess.valueOf("Inspected"), StatusProcess.Inspected);
        assertSame(StatusProcess.valueOf("Canceled"), StatusProcess.Canceled);
        assertSame(StatusProcess.valueOf("AwaitingRepair"), StatusProcess.AwaitingRepair);
        assertSame(StatusProcess.valueOf("Repaired"), StatusProcess.Repaired);
        assertSame(StatusProcess.valueOf("Invoiced"), StatusProcess.Invoiced);
    }
}

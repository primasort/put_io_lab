package put.io.testing.mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ExpenseRepositoryTest {

    private ExpenseRepository expenseRepository;
    private List<Expense> expenses;

    @Test
    void loadExpensesTest() {
        IFancyDatabase mockDb = mock(IFancyDatabase.class);
        InOrder inOrd = inOrder(mockDb);
        when(mockDb.queryAll()).thenReturn(Collections.emptyList());
        expenseRepository = new ExpenseRepository(mockDb);
        expenseRepository.loadExpenses();
        inOrd.verify(mockDb).connect();
        inOrd.verify(mockDb).queryAll();
        inOrd.verify(mockDb).close();
        assertEquals(0, expenseRepository.getExpenses().size());
    }

    @Test
    void saveExpensesTest(){
        IFancyDatabase mockDb = mock(IFancyDatabase.class);
        InOrder inOrd = inOrder(mockDb);
        when(mockDb.queryAll()).thenReturn(Collections.emptyList());
        expenseRepository = new ExpenseRepository((mockDb));
        IntStream.range(0,5).forEach(i -> expenseRepository.addExpense(new Expense()));
        expenseRepository.saveExpenses();
        verify(mockDb, times(5)).persist(any(Expense.class));
        inOrd.verify(mockDb).connect();
        inOrd.verify(mockDb).close();
    }
}

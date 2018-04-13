import com.endsound.ExamEvaluator;
import com.endsound.bean.WinningCombination;
import com.genesis.exams.slot.Evaluator;
import com.genesis.exams.slot.Symbol;
import org.junit.Test;

public class EvaluatorTest {
    private Evaluator evaluator;

    public EvaluatorTest(){
        Symbol symbolA = new Symbol("A", 1);
        Symbol symbolB = new Symbol("B", 1);
        Symbol symbolC = new Symbol("C", 1);
        this.evaluator = new ExamEvaluator(new WinningCombination[]{
                new WinningCombination(new Symbol[]{symbolA, symbolA, symbolA}, 20),
                new WinningCombination(new Symbol[]{symbolA, symbolA, symbolA}, 20),
                new WinningCombination(new Symbol[]{symbolA, symbolA, symbolA}, 20),
                new WinningCombination(new Symbol[]{symbolA, symbolB, symbolC}, 30)
        });
    }

    @Test
    public void evaluatorTestAAA(){
        Symbol[] symbols = new Symbol[]{new Symbol("B", 1), new Symbol("A", 1), new Symbol("C", 1)};

        System.out.println(evaluator.evaluate(symbols, 10));
    }
}

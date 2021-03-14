package search;

import java.util.List;
import java.util.Map;

public class SearchEngine {
    SearchingMethod strategy;
    public SearchEngine(SearchingMethod strategy){
        this.strategy = strategy;
    }
    void Search(Map<String, List<Integer>> invertedIndexes, List<String> people){
        strategy.Search(invertedIndexes, people);
    }
}

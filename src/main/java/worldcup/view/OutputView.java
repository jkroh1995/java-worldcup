package worldcup.view;

import worldcup.domain.Group;
import worldcup.domain.GroupList;
import worldcup.domain.Match;
import worldcup.domain.Operation;
import worldcup.domain.MatchList;
import worldcup.domain.WorldResult;

public class OutputView {

    private static final String REQUIRE_OPERATION = "출력할 내용을 입력하세요. (1 ~ 5)";
    private static final String PRINT_EXIT = "프로그램을 종료합니다.";
    private static final String REQUIRE_GROUP = "출력할 조를 입력하세요 (A ~ H)";

    public void printError(String message) {
        System.out.println(message);
    }

    public void requireOperation() {
        printBlankLine();
        System.out.println(REQUIRE_OPERATION);
    }

    public void printOperation() {
        for(Operation operation : Operation.values()){
            System.out.println(operation.getOperationIndex() + operation.getOperation());
        }
        printBlankLine();
    }

    private void printBlankLine() {
        System.out.println();
    }

    public void printAllMatches(GroupList groupList, MatchList matchList) {
        printCloseLine();
        for(Group group : groupList.getGroupList()){
            System.out.println(group.getGroup());
            printEachMatch(matchList, group);
            printBlankLine();
        }
        printCloseLine();
    }

    private void printCloseLine() {
        System.out.println("============================================================\n");
    }

    private void printEachMatch(MatchList matchList, Group group) {
        for(Match match : matchList.getMatchList()){
            if(group.equals(match.getGroup())){
                System.out.println(match.getMatch());
            }
        }
    }

    public void printExit() {
        System.out.println(PRINT_EXIT);
    }

    public void requireGroup() {
        System.out.println(REQUIRE_GROUP);
    }

    public void requireWorld() {
        System.out.println("출력할 국가를 입력하세요 (월드컵 출전 국가)");
    }

    public void printWorldResult(WorldResult worldResult, MatchList allMatches) {
        System.out.println(worldResult.toString());
        for(Match match : allMatches.getMatchList()){
            if(match.getWorldList().contains(worldResult.getWorld())){
                System.out.println(match.getMatch());
            }
        }
        printCloseLine();
    }
}

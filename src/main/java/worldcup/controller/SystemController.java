package worldcup.controller;

import worldcup.controller.domain.MatchController;
import worldcup.domain.Group;
import worldcup.domain.GroupList;
import worldcup.domain.Operation;
import worldcup.domain.MatchList;
import worldcup.domain.MatchResultList;
import worldcup.domain.World;
import worldcup.domain.WorldResult;
import worldcup.view.InputView;
import worldcup.view.OutputView;

public class SystemController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    MatchController matchController = new MatchController();

    public void run() {
        Operation operation = inputView.readOperation();
        if(operation == Operation.MATCH_RESULT){
            MatchList matchList = matchController.getAllMatches();
            GroupList groupList = matchController.getGroupList();
            outputView.printAllMatches(groupList, matchList);
            run();
        }
        if(operation == Operation.GROUP_RESULT){
            Group group = inputView.readGroup(matchController.getGroupList());
        }
        if(operation == Operation.WORLD_RESULT){
            World world = inputView.readWorld(matchController.getWorldList());
            WorldResult worldResult = matchController.getWorldResult(world);
            outputView.printWorldResult(worldResult, matchController.getAllMatches());
            run();
        }
        if(operation == Operation.ROUND16_RESULT){

        }
        if(operation == Operation.EXIT){
            outputView.printExit();
        }
    }
}

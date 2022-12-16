package worldcup.view;

import camp.nextstep.edu.missionutils.Console;
import worldcup.domain.Group;
import worldcup.domain.GroupList;
import worldcup.domain.Operation;
import worldcup.domain.World;
import worldcup.domain.WorldList;

public class InputView {

    OutputView outputView = new OutputView();

    public Operation readOperation() {
        try{
            outputView.printOperation();
            outputView.requireOperation();
            String inputOperation = Console.readLine();
            return Operation.makeOperation(inputOperation);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return readOperation();
        }
    }

    public Group readGroup(GroupList groupList) {
        try{
            outputView.requireGroup();
            String inputGroup = Console.readLine();
            groupList.checkGroup(inputGroup);
            return new Group(inputGroup);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return readGroup(groupList);
        }
    }

    public World readWorld(WorldList worldList) {
        try{
            outputView.requireWorld();
            String inputWorld = Console.readLine();
            worldList.checkWorldList(inputWorld);
            return new World(inputWorld);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return readWorld(worldList);
        }
    }
}

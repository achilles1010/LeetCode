package learn.patterns.create.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
@Data
@AllArgsConstructor
public class PlayController {
   public MusicPlayer construct(AbstractPlayerBuilder pb){
       pb.buildType();
       pb.buildMenu();
       pb.buildPlayerList();
       pb.buildMainWindows();
       pb.buildControlStrip();
       pb.buildCollectionList();
       return pb.createPlayer();
   }

    public static void main(String[] args) {
        MusicPlayer player = new PlayController().construct(new SimplePlayerBuilder());
        System.out.println(player.toString());
    }
}

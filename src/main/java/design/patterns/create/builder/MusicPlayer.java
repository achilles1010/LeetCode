package design.patterns.create.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Music player.
 *
 * @author daixulin
 * @version : v1.0
 * @date 2020 -06-05 4:54 下午 周五
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicPlayer {
    private String type;
    private String menu;
    private String playerList;
    private String mainWindows;
    private String controlStrip;
    private String collectionList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("这是一个 ").append(type).append(" 音乐播放器\n\n");
        sb.append("播放器拥有：\n");
        if (menu != null) {
            sb.append(menu).append("\n");
        }
        if (playerList != null) {
            sb.append(playerList).append("\n");
        }
        if (mainWindows != null) {
            sb.append(mainWindows).append("\n");
        }
        if (controlStrip != null) {
            sb.append(controlStrip).append("\n");
        }
        if (collectionList != null) {
            sb.append(collectionList).append("\n");
        }
        return sb.toString();
    }
}

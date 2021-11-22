package hk.edu.polyu.comp5112;

/**
 * @author HUANG Zuo
 * @version create_time：2021-11-10 23:04:01
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class CalHowManyBlocks {

    public static void main(String[] args) {
        int blockSize = 512;
        int rows = 100;

        //original data blocks
        int sid = 10;
        int totalDataSize = sid+50+10+8+50;
        int dataBlocks = blockSize / totalDataSize;
        System.out.println("ori data count per block : " + dataBlocks);

        //index blocks
        int pointer = 6;
        int indexSize = pointer + sid;
        int indexCountPerBlock = blockSize / indexSize;
        System.out.println("indexCountPerBlock :" + indexCountPerBlock );
        double indexBlocks = (double) rows / indexCountPerBlock;
        System.out.println("all indexes need " + indexBlocks + " blocks");
    }
}

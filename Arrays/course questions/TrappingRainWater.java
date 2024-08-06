
public class TrappingRainWater {
    public static int calcVolume(int height[], int width){
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        int volume=0;
        //calculating maximum left and right boundary of each bar
        for(int i = 0; i < height.length; i++){
            leftMax[i] = height[i];
            rightMax[i] = height[i];
        }
        for(int i = 1; i < height.length; i++){
            if(leftMax[i] < leftMax[i-1])
                leftMax[i] = leftMax[i-1];
        }
        for(int i = height.length-2; i >= 0; i--){
            if(rightMax[i] < rightMax[i+1])
                rightMax[i] = rightMax[i+1];
        }
        //calculating total volume
        for(int i = 0; i < height.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            volume += (waterLevel - height[i])*width;
        }

        return volume;
    }
    public static void main(String[] args) {
        int height[] = {4, 2, 0, 3, 2, 5};
        System.out.println(calcVolume(height, 1));
    }
}

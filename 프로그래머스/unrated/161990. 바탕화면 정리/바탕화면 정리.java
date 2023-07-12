class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 51, minY = 51, maxX = 0, maxY = 0;
        
        for (int i = 0; i < wallpaper.length; i++){
            if (wallpaper[i].indexOf("#") >= 0){
                minX = Math.min(minX, wallpaper[i].indexOf("#"));
                maxX = Math.max(maxX, wallpaper[i].lastIndexOf("#"));
                if (minY > 50) minY = i;
                maxY = i;
            }
        }
        return new int[]{minY, minX, maxY+1, maxX+1};
    }
}
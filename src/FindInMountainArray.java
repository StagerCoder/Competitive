public class FindInMountainArray {

    static interface MountainArray {
        int get(int index);

        int length();
    }

    static class MountainArrayImplementation implements MountainArray {
        int[] arr = {1,2,3,4,5,3,1};
        int[] arr2 = {0, 1, 2, 4, 2, 1};

        @Override
        public int get(int index) {
            //Example 1
            return arr[index];
//            //Example 2
//            return arr2[index];
        }

        @Override
        public int length() {
            //Example 1
            return arr.length;
//            //Example 2
//            return arr2.length;
        }
    }


    public static void main(String[] args) {
        MountainArrayImplementation mountainArrayImplementation = new MountainArrayImplementation();
        System.out.println(findInMountainArray(1, mountainArrayImplementation));
    }

    static int findInMountainArray(int target, MountainArray mountainArr) {
        int indexOfMid = findPivot(mountainArr);
        int leftSideArray = binarySearch(mountainArr, target, 0, indexOfMid);
        int rightSideArray = binarySearch(mountainArr, target, indexOfMid + 1, mountainArr.length() - 1);
        if (leftSideArray == -1 && rightSideArray != -1) {
            return rightSideArray;
        } else if (rightSideArray == -1 && leftSideArray != -1) {
            return leftSideArray;
        } else {
            return Math.min(leftSideArray, rightSideArray);
        }
    }

    static int findPivot(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    static int binarySearch(MountainArray mountainArray, int target, int start, int end) {
        boolean desc = mountainArray.get(start) > mountainArray.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArray.get(mid) == target) {
                return mid;
            } else if (desc && mountainArray.get(mid) > target || mountainArray.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

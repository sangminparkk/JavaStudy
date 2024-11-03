package me.chandler.ch8;

import java.io.File;
import java.io.IOException;

public class _Throws_4 {

    public static void main(String[] args) {
        File newFile = createFile(args[0]);
        System.out.println(newFile.getName() + " 파일이 성공적으로 생성되었습니다.");

    }

    private static File createFile(String fileName) {
        // 리팩토링
        if (fileName == null || fileName.isBlank()) {
            fileName = "제목없음.txt";
        }

        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}

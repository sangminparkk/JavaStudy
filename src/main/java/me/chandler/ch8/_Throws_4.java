package me.chandler.ch8;

import java.io.File;
import java.io.IOException;

public class _Throws_4 {

    public static void main(String[] args) {
        try {
            File newFile = createFile(args[0]);
            System.out.println(newFile.getName() + " 파일이 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해주세요");
        }
    }

    private static File createFile(String fileName) throws Exception {
        // 리팩토링
        if (fileName == null || fileName.isBlank()) {
            throw new Exception("파일 이름이 유효하지 않습니다.");
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

package me.chandler.ch8;

import java.io.File;
import java.io.IOException;

public class _Throws_3 {

    public static void main(String[] args) {
        File newFile = createFile(args[0]);
        System.out.println(newFile.getName() + " 파일이 성공적으로 생성되었습니다.");
    }

    private static File createFile(String fileName) {

        // 예외 먼저 처리 : try - catch - finally
        try {
            if (fileName == null || fileName.equals("")) {
                throw new Exception("파일이름이 유효하지 않습니다.");
            }
        } catch (Exception e) {
            // 파일이름이 유효하지 않을때
            fileName = "제목없음.txt";
        } finally {
            File file = new File(fileName);
            createNewFile(file);
            return file;
        }
    }

    private static void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

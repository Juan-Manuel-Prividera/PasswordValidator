package service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorTest {

    PasswordValidator validador;

    @Test
    public void testIsLongEnough(){
        validador = new PasswordValidator("blacklist.txt");
        Assertions.assertTrue(validador.validate("passwordLarga"));
    }

    @Test
    public void testIsNotLongEnough(){
        validador = new PasswordValidator("blacklist.txt");
        Assertions.assertFalse(validador.validate("lol"));
    }

    @Test
    public void testWithBlackList() {
        validador = new PasswordValidator("blacklist.txt");
        Assertions.assertFalse(validador.validate("password"));
    }

    @Test
    public void testWithoutBlackList() {
        validador = new PasswordValidator(null);
        Assertions.assertTrue(validador.validate("password"));
    }

    @Test
    public void withWrongBlacklistPath() {
        validador = new PasswordValidator("NotAnExistingFile.txt");
        Assertions.assertTrue(validador.validate("password"));
    }

    @Test
    public void isValidPassword(){
        validador = new PasswordValidator("blacklist.txt");
        Assertions.assertTrue(validador.validate("AguanteLaUTNloco"));
    }

    @Test
    public void isNotAValidPassword(){
        validador = new PasswordValidator("blacklist.txt");
        Assertions.assertFalse(validador.validate("password"));
    }


}
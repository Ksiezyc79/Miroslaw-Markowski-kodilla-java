package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);
        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfBooksZero() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("Mirek", "M", "79112155789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> zeroBooks = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(zeroBooks);
        //When
        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(0, resultListBooksInHandsOf.size());
    }

    @Test
    public void testListBooksInHandsOfBooksOne() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("Mirek", "M", "79112155789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> oneBook = generateListOfNBooks(1);
        when((libraryDatabaseMock.listBooksInHandsOf(libraryUser))).thenReturn(oneBook);
        //When
        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(1,resultListBooksInHandsOf.size() );
    }

    @Test
    public void testListBooksInHandsOfBooksFive() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("Mirek", "M", "79112155789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> fiveBooks = generateListOfNBooks(5);
        when((libraryDatabaseMock.listBooksInHandsOf(libraryUser))).thenReturn(fiveBooks);
        //When
        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(5, resultListBooksInHandsOf.size());
    }
}

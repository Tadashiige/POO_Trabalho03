package br.com.icmc.trabalho03;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Library extends Application{

	public static final double WIDTH = 900.0;
	public static final double HEIGHT = WIDTH*9/16;		
	
	private LibraryManager manager = null;
	
	private StackPane principalSection = null;
	
	private StackPane homePane = null;
	private StackPane signupPane = null;
	private StackPane userSignupPane = null;
	private StackPane bookSignupPane = null;
	private StackPane registerPane = null;
	private StackPane borrowPane = null;
	private StackPane returnPane = null;
	private StackPane returnCalPane = null;
	private StackPane listPane = null;
	private StackPane userListPane = null;
	private StackPane bookListPane = null;
	private StackPane borrowListPane = null;

	private Label banner = null;
	
	/**
	 * 
	 * *******************************************************************************************
	 * 
	 * Métodos Set-Get dos Panes
	 * 
	 */
	
	//SETs ------------------------------------
	
	private void setLibraryManager (LibraryManager manager){
		this.manager = manager;
	}
	
	private void setPrincipalSection(StackPane principalSection){
		this.principalSection = principalSection;
	}
	
	private void setBanner(Label banner){
		this.banner = banner;
	}
	
	private void setHomePane(StackPane homePane){
		this.homePane = homePane;
	}
	
	private void setSignupPane(StackPane signupPane){
		this.signupPane = signupPane;
	}

	private void setUserSignupPane(StackPane userSignupPane){
		this.userSignupPane = userSignupPane;
	}
	
	private void setBookSignupPane(StackPane bookSignupPane){
		this.bookSignupPane = bookSignupPane;
	}
	
	private void setRegisterPane(StackPane registerPane){
		this.registerPane = registerPane;
	}
	
	private void setBorrowPane(StackPane borrowPane){
		this.borrowPane = borrowPane;
	}
	
	private void setReturnPane(StackPane returnPane){
		this.returnPane = returnPane;
	}

	private void setReturnCalPane(StackPane returnCalPane){
		this.returnCalPane = returnCalPane;
	}

	private void setListPane(StackPane listPane){
		this.listPane = listPane;
	}

	private void setUserListPane(StackPane userListPane){
		this.userListPane = userListPane;
	}

	private void setBookListPane(StackPane bookListPane){
		this.bookListPane = bookListPane;
	}

	private void setBorrowListPane(StackPane borrowListPane){
		this.borrowListPane = borrowListPane;
	}
	
	//------------- END SET -------------------
	
	//GETs ------------------------------------
	
	private LibraryManager getLibraryManager (){
		return this.manager;
	}
	
	private StackPane getPrincipalSection (){
		return this.principalSection;
	}
	
	private Label getBanner (){
		return this.banner;
	}
	
	private StackPane getHomePane(){
		return this.homePane;
	}
	
	private StackPane getSignupPane(){
		return this.signupPane;
	}

	private StackPane getUserSignupPane(){
		return this.userSignupPane;
	}

	private StackPane getBookSignupPane(){
		return this.bookSignupPane;
	}

	private StackPane getRegisterPane(){
		return this.registerPane;
	}

	private StackPane getBorrowPane(){
		return this.borrowPane;
	}

	private StackPane getReturnPane(){
		return this.returnPane;
	}

	private StackPane getReturnCalPane(){
		return this.returnCalPane;
	}

	private StackPane getListPane(){
		return this.listPane;
	}

	private StackPane getUserListPane(){
		return this.userListPane;
	}

	private StackPane getBookListPane(){
		return this.bookListPane;
	}

	private StackPane getBorrowListPane(){
		return this.borrowListPane;
	}
	
	//-------------- END GET -----------------
	
	// ---------------------------------- END GET-SET METHODS -------------------------------------------------
	
	public static void main(String[] args) {
		
		launch();
	}

	private void tradeSectionPane (StackPane section, String label) {
		getPrincipalSection().getChildren().remove(getPrincipalSection().getChildren().size()-1);
		getPrincipalSection().getChildren().add(section);
		getBanner().setText(label);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {		
		
		/**
		 * 
		 * *********************************************************************************************************
		 * 
		 * Setup geral para a página principal.
		 * A visão da aplicação terá um banner do software ao topo;
		 * uma barra lateral contendo botões para acesso ao homepage, 
		 * formulários/listas de cadastro de livros e usuários, 
		 * registro de empréstimo e devolução de livros, cálculo 
		 * de suspensões e listas de usuários, livros, e livros 
		 * emprestados; e uma sessão de formulários/listas que
		 * será trocado de acordo com a requisição do usuário
		 * disparado pelos botões laterais.
		 */
		
		VBox generalPageView = new VBox();
		
		//Criação do Banner
		
		Label banner = new Label ("Library v1.0");
		banner.setPrefHeight(HEIGHT/6);
		banner.setPrefWidth(WIDTH);
		banner.setAlignment(Pos.CENTER);
		banner.setTextFill(Color.BLUE);
		banner.setFont(Font.font("Cambria", 32));
		setBanner(banner);
		generalPageView.getChildren().add(banner);
		
		/**
		 * CRIAÇÃO DA BARRA LATERAL **************************************************************************************
		 * 
		 * barra lateral e sessão principal deve ser disposto lado a lado
		 */		
		
		HBox principalContent = new HBox ();
		principalContent.setPrefHeight(HEIGHT*5/6);
		generalPageView.getChildren().add(principalContent);
		

		VBox sideNavigator = new VBox();
		sideNavigator.setPrefWidth(WIDTH/6);
		sideNavigator.setPrefHeight(HEIGHT*5/6);
		
		/**
		 * Criação da barra lateral - BOTÕES *****************************************************************************
		 */		
		
		Button homeButton = new Button ("Home");
		homeButton.setPrefHeight(HEIGHT*5/30);
		homeButton.setPrefWidth(WIDTH/6);
		
		Button signUpButton = new Button ("Sign Up");
		signUpButton.setPrefHeight(HEIGHT*5/30);
		signUpButton.setPrefWidth(WIDTH/6);

		Button userSignUpButton = new Button ("User Sign Up");
		userSignUpButton.setPrefHeight(HEIGHT*5/30);
		userSignUpButton.setPrefWidth(WIDTH/6);
		
		Button bookSignUpButton = new Button ("Book Sign Up");
		bookSignUpButton.setPrefHeight(HEIGHT*5/30);
		bookSignUpButton.setPrefWidth(WIDTH/6);
		
		Button borrowReturnButton = new Button ("Borrow/Return");
		borrowReturnButton.setPrefHeight(HEIGHT*5/30);
		borrowReturnButton.setPrefWidth(WIDTH/6);

		Button borrowButton = new Button ("Borrow");
		borrowButton.setPrefHeight(HEIGHT*5/30);
		borrowButton.setPrefWidth(WIDTH/6);

		Button returnButton = new Button ("Return");
		returnButton.setPrefHeight(HEIGHT*5/30);
		returnButton.setPrefWidth(WIDTH/6);
		
		Button returnCalButton = new Button ("Return Cal");
		returnCalButton.setPrefHeight(HEIGHT*5/30);
		returnCalButton.setPrefWidth(WIDTH/6);
		
		Button listButton = new Button ("List");
		listButton.setPrefHeight(HEIGHT*5/30);
		listButton.setPrefWidth(WIDTH/6);
		
		Button userListButton = new Button ("User List");
		userListButton.setPrefHeight(HEIGHT*5/30);
		userListButton.setPrefWidth(WIDTH/6);

		Button bookListButton = new Button ("Book List");
		bookListButton.setPrefHeight(HEIGHT*5/30);
		bookListButton.setPrefWidth(WIDTH/6);
		
		Button borrowListButton = new Button ("Borrow List");
		borrowListButton.setPrefHeight(HEIGHT*5/30);
		borrowListButton.setPrefWidth(WIDTH/6);
		
		
		/**
		 * -------------------------------------- FIM CRIAÇÃO DOS BOTÕES ----------------------------------------------
		 */
		
		sideNavigator.getChildren().addAll(
				homeButton,
				signUpButton,
				//userSignUpButton,
				//bookSignUpButton,
				borrowReturnButton,
				//borrowButton,
				//returnButton,
				returnCalButton,
				listButton
				//userListButton,
				//bookListButton,
				//borrowListButton
			);
		
		principalContent.getChildren().add(sideNavigator);
		
		/**
		 * -------------------------------------- FIM CRIAÇÃO DA BARRA LATERAL ---------------------------------------
		 */
		
		//Criação da sessão que terá seu conteúdo trocado		
		//de acordo com a requisição do usuário.
		
		StackPane principalSection = new StackPane ();
		principalSection.setPrefWidth(WIDTH*5/6);
		setPrincipalSection(principalSection);
		principalContent.getChildren().add(principalSection);
		
		
		//Criação da cena.
		
		Scene scn = new Scene (generalPageView, WIDTH, HEIGHT, Color.BLUE);
		primaryStage.setScene(scn);
		
		
		/** ---------------- FIM SETUP GENÉRICO --------------------------------------------------------------
		*
		*/
		
		/**
		 * 
		 * **************************************************************************************************
		 * 
		 * Setup das sessões específicas de requisão por botão do usuário:
		 * 1 - Home Page
		 * 2 - Cadastro de usuário e livros
		 * 3 - Registro de empréstimo e devolução
		 * 4 - Cálculo de suspensão de usuário
		 * 5 - Listagem de usuários, livros e livros impressos
		 */
		
		//variáveis auxiliares
		VBox auxVBox = null;
		HBox auxHBox = null;
		
		//Home Page
		
		setHomePane(new StackPane());
		Label wellcome = new Label ("Wellcome !!");
		getHomePane().getChildren().add(wellcome);		
				
		
		//Cadastro de usuários e livros		
		
		setSignupPane(new StackPane());		
		Label signup = new Label ("SignUp !!");
		signup.setPrefHeight(HEIGHT*5/18);
		signup.setPrefWidth(WIDTH*5/6);
		signup.setAlignment(Pos.CENTER);
		signup.setTextFill(Color.GREEN);
		signup.setFont(Font.font("Cambria", 16));
		auxVBox = new VBox ();		
		auxVBox.getChildren().add(signup);
		auxHBox = new HBox ();
		auxVBox.getChildren().add(auxHBox);
		auxHBox.getChildren().add(userSignUpButton);
		auxHBox.getChildren().add(bookSignUpButton);
		userSignUpButton.setTranslateX(WIDTH/6);
		bookSignUpButton.setTranslateX(WIDTH/3);
		auxHBox.setPrefHeight(HEIGHT*5/9);
		getSignupPane().getChildren().add(auxVBox);
		auxVBox = null;
		auxHBox = null;
				
		//Cadastro de usuários
		
		setUserSignupPane (new StackPane());		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);
		
		Label userNameLabel = new Label("Nome: ");		
		TextField userName = new TextField();
		auxHBox.getChildren().addAll(userNameLabel, userName);
		auxVBox.getChildren().add(auxHBox);
		
		auxHBox = new HBox();
		Label relationListLabel = new Label("Vínculo com a Universidade: ");
		ObservableList<String> relationship = FXCollections.observableArrayList(
				"aluno", "professor", "comunidade");
		ComboBox relationList = new ComboBox(relationship);
		auxHBox.getChildren().addAll(relationListLabel, relationList);		
		auxVBox.getChildren().add(auxHBox);
		
		auxHBox = new HBox();
		Label documentLabel = new Label("NºUSP/RG: ");
		TextField documentNumb = new TextField();
		auxHBox.getChildren().addAll(documentLabel, documentNumb);		
		auxVBox.getChildren().add(auxHBox);
		
		Button sendSignUpButton = new Button ("Cadastrar");
		auxVBox.getChildren().add(sendSignUpButton);
		
		getUserSignupPane().getChildren().add(auxVBox);		
		
		//Cadastro de livros

		setBookSignupPane (new StackPane());
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);
		
		Label bookNameLabel = new Label("Livro: ");		
		TextField bookName = new TextField();
		auxHBox.getChildren().addAll(bookNameLabel, bookName);
		auxVBox.getChildren().add(auxHBox);
		
		auxHBox = new HBox();
		Label bookListLabel = new Label("Tipo de Livro: ");
		ObservableList<String> typeBook = FXCollections.observableArrayList(
				"texto", "geral");
		ComboBox typeBookList = new ComboBox(typeBook);
		auxHBox.getChildren().addAll(bookListLabel, typeBookList);		
		auxVBox.getChildren().add(auxHBox);
		
		Button sendBookSignUpButton = new Button ("Cadastrar");
		auxVBox.getChildren().add(sendBookSignUpButton);
		
		getBookSignupPane().getChildren().add(auxVBox);		

				
		//Registro de empréstimo/devolução
		
		setRegisterPane(new StackPane());		
		Label register = new Label ("Register !!");
		register.setPrefHeight(HEIGHT*5/18);
		register.setPrefWidth(WIDTH*5/6);
		register.setAlignment(Pos.CENTER);
		register.setTextFill(Color.GREEN);
		register.setFont(Font.font("Cambria", 16));
		auxVBox = new VBox ();		
		auxVBox.getChildren().add(register);
		auxHBox = new HBox ();
		auxVBox.getChildren().add(auxHBox);
		auxHBox.getChildren().add(borrowButton);
		auxHBox.getChildren().add(returnButton);
		borrowButton.setTranslateX(WIDTH/6);
		returnButton.setTranslateX(WIDTH/3);
		auxHBox.setPrefHeight(HEIGHT*5/9);
		getRegisterPane().getChildren().add(auxVBox);		
		auxVBox = null;
		auxHBox = null;
		
		//Registro de Emprestimo
		
		setBorrowPane(new StackPane());
		
		HBox hboxSide = new HBox ();
		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);
		
		//Lado de informações do usuário
		
		Label idUserLabel = new Label("NºUSP/RG: ");		
		TextField idUser = new TextField();
		auxHBox.getChildren().addAll(idUserLabel, idUser);
		auxVBox.getChildren().add(auxHBox);
		
		Button searchUser = new Button ("Buscar Usuário");
		auxVBox.getChildren().add(searchUser);
		
		ObservableList<String> userListBook = FXCollections.observableArrayList();
		ListView<String> userBookListView = new ListView<String>(userListBook);			
		auxVBox.getChildren().add(userBookListView);
		
		hboxSide.getChildren().add(auxVBox);
		
		auxVBox = new VBox();
		
		//Lado de informações sobre livros
		
		auxHBox = new HBox();
		Label idLabel = new Label("ID: ");		
		TextField bookId = new TextField();
		auxHBox.getChildren().addAll(idLabel, bookId);
		auxVBox.getChildren().add(auxHBox);

		auxHBox = new HBox();
		Label bookNameSearchLabel = new Label("Name: ");		
		TextField bookNameSearch = new TextField();
		auxHBox.getChildren().addAll(bookNameSearchLabel, bookNameSearch);
		auxVBox.getChildren().add(auxHBox);
		
		Button bookSearchButton = new Button ("Buscar");
		auxVBox.getChildren().add(bookSearchButton);
		
		auxHBox = new HBox();
		Label bookSearchListLabel = new Label("Livros: ");
		ObservableList<String> searchListBook = FXCollections.observableArrayList();
		ListView<String> bookSearchList = new ListView<String>(searchListBook);
		auxHBox.getChildren().addAll(bookSearchListLabel, bookSearchList);		
		auxVBox.getChildren().add(auxHBox);
		
		auxHBox = new HBox();
		Label borrowBookId = new Label ("ID: ");
		Label borrowBookName = new Label ("Name: ");
		borrowBookId.setAlignment(Pos.CENTER);
		borrowBookId.setTextFill(Color.GREEN);
		borrowBookId.setFont(Font.font("Cambria", 16));
		borrowBookName.setAlignment(Pos.CENTER);
		borrowBookName.setTextFill(Color.GREEN);
		borrowBookName.setFont(Font.font("Cambria", 16));
		auxHBox.getChildren().addAll(borrowBookId, borrowBookName);
		
		Button bookBorrowButton = new Button ("Retirar");
		auxHBox.getChildren().add(bookBorrowButton);
		
		auxVBox.getChildren().add(auxHBox);
		
		hboxSide.getChildren().add(auxVBox);
		
		getBorrowPane().getChildren().add(hboxSide);		
		
		//Registro de devolução
		
		setReturnPane(new StackPane());				
		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);		
		
		idUserLabel = new Label("NºUSP/RG: ");		
		idUser = new TextField();
		auxHBox.getChildren().addAll(idUserLabel, idUser);
		auxVBox.getChildren().add(auxHBox);
		
		searchUser = new Button ("Buscar Usuário");
		auxVBox.getChildren().add(searchUser);
		
		userListBook = FXCollections.observableArrayList();
		userBookListView = new ListView<String>(userListBook);			
		auxVBox.getChildren().add(userBookListView);					
		
		auxHBox = new HBox();
		borrowBookId = new Label ("ID: ");
		borrowBookName = new Label ("Name: ");
		borrowBookId.setAlignment(Pos.CENTER);
		borrowBookId.setTextFill(Color.GREEN);
		borrowBookId.setFont(Font.font("Cambria", 16));
		borrowBookName.setAlignment(Pos.CENTER);
		borrowBookName.setTextFill(Color.GREEN);
		borrowBookName.setFont(Font.font("Cambria", 16));
		auxHBox.getChildren().addAll(borrowBookId, borrowBookName);
		
		Button bookReturnButton = new Button ("Devolver");
		auxHBox.getChildren().add(bookReturnButton);
		
		auxVBox.getChildren().add(auxHBox);			
		
		getReturnPane().getChildren().add(auxVBox);						
		
		//Cálculo de suspensão
		
		setReturnCalPane(new StackPane());		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);		
		
		idUserLabel = new Label("NºUSP/RG: ");		
		idUser = new TextField();
		auxHBox.getChildren().addAll(idUserLabel, idUser);
		auxVBox.getChildren().add(auxHBox);
		
		searchUser = new Button ("Buscar Usuário");
		auxVBox.getChildren().add(searchUser);
		
		userListBook = FXCollections.observableArrayList();
		userBookListView = new ListView<String>(userListBook);			
		auxVBox.getChildren().add(userBookListView);					
		
		auxHBox = new HBox();
		Label delayedBooksUnit = new Label ("Livros atrasados: ");
		Label suspensionCountUnit = new Label ("Créditos de suspensão: ");
		Label suspensionTime = new Label ("Tempo de suspensão: ");
		
		auxHBox.getChildren().addAll(delayedBooksUnit, suspensionCountUnit, suspensionTime);
		
		auxVBox.getChildren().add(auxHBox);
		
		getReturnCalPane().getChildren().add(auxVBox);
		
		//Listagem
		
		setListPane(new StackPane());
		Label list = new Label ("List !!");
		list.setPrefHeight(HEIGHT*5/18);
		list.setPrefWidth(WIDTH*5/6);
		list.setAlignment(Pos.CENTER);
		list.setTextFill(Color.GREEN);
		list.setFont(Font.font("Cambria", 16));
		auxVBox = new VBox ();		
		auxVBox.getChildren().add(list);
		auxHBox = new HBox ();
		auxVBox.getChildren().add(auxHBox);
		auxHBox.getChildren().add(userListButton);
		auxHBox.getChildren().add(bookListButton);
		auxHBox.getChildren().add(borrowListButton);
		userListButton.setTranslateX(WIDTH/6);
		bookListButton.setTranslateX(WIDTH/6);
		borrowListButton.setTranslateX(WIDTH/6);
		auxHBox.setPrefHeight(HEIGHT*5/9);		
		getListPane().getChildren().add(auxVBox);		
		auxVBox = null;
		auxHBox = null;

		//Listagem de Usuários
		
		setUserListPane(new StackPane());
		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);		
		
		idUserLabel = new Label("NºUSP/RG: ");		
		idUser = new TextField();
		auxHBox.getChildren().addAll(idUserLabel, idUser);
		auxVBox.getChildren().add(auxHBox);
		
		searchUser = new Button ("Buscar Usuário");
		auxVBox.getChildren().add(searchUser);
		
		ObservableList<String> userList = FXCollections.observableArrayList();
		ListView<String> userListView = new ListView<String>(userList);
		
		auxVBox.getChildren().add(userListView);
		
		getUserListPane().getChildren().add(auxVBox);

		//Listagem de Livros
		
		setBookListPane(new StackPane());
		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);		
		
		Label idBookIdLabel = new Label("ID: ");		
		TextField idBook = new TextField();
		auxHBox.getChildren().addAll(idBookIdLabel, idBook);
		auxVBox.getChildren().add(auxHBox);
		
		auxHBox = new HBox();
		Label idBookNameLabel = new Label("Nome: ");		
		TextField nameBook = new TextField();
		auxHBox.getChildren().addAll(idBookNameLabel, nameBook);
		auxVBox.getChildren().add(auxHBox);
		
		Button searchBook = new Button ("Buscar Livro");
		auxVBox.getChildren().add(searchBook);
		
		ObservableList<String> bookList = FXCollections.observableArrayList();
		ListView<String> bookListView = new ListView<String>(bookList);
		
		auxVBox.getChildren().add(bookListView);
		
		getBookListPane().getChildren().add(auxVBox);
		
		//Listagem de Livros emprestados
		
		setBorrowListPane(new StackPane());
		
		auxVBox = new VBox();
		auxHBox = new HBox();
		
		auxVBox.setPrefHeight(HEIGHT*5/6);
		auxVBox.setPrefHeight(WIDTH*5/6);
		auxVBox.setAlignment(Pos.CENTER);		
		
		Label idBorrowedBookIdLabel = new Label("ID: ");		
		TextField idBorrowedBook = new TextField();
		auxHBox.getChildren().addAll(idBorrowedBookIdLabel, idBorrowedBook);
		auxVBox.getChildren().add(auxHBox);
		
		auxHBox = new HBox();
		Label idBorrowedBookNameLabel = new Label("Nome: ");		
		TextField nameBorrowedBook = new TextField();
		auxHBox.getChildren().addAll(idBorrowedBookNameLabel, nameBorrowedBook);
		auxVBox.getChildren().add(auxHBox);
		
		searchBook = new Button ("Buscar Livro");
		auxVBox.getChildren().add(searchBook);
		
		bookList = FXCollections.observableArrayList();
		bookListView = new ListView<String>(bookList);
		
		auxVBox.getChildren().add(bookListView);
		
		getBorrowListPane().getChildren().add(auxVBox);		
		
		/** ********************************************************************************************************
		 * Configuração da ações dos botões de troca de Pane
		 */

		homeButton.setOnMouseClicked(event->{
			tradeSectionPane(getHomePane(), "Library v1.0");
		});

		signUpButton.setOnMouseClicked(event->{
			tradeSectionPane(getSignupPane(), "SignUp");
		});
		

		userSignUpButton.setOnMouseClicked(event->{
			tradeSectionPane(getUserSignupPane(), "User SignUp");
		});

		bookSignUpButton.setOnMouseClicked(event->{
			tradeSectionPane(getBookSignupPane(), "Book SignUp");
		});
		
		borrowReturnButton.setOnMouseClicked(event->{
			tradeSectionPane(getRegisterPane(), "Borrow and Return");
		});

		borrowButton.setOnMouseClicked(event->{
			tradeSectionPane(getBorrowPane(), "Borrow");
		});

		returnButton.setOnMouseClicked(event->{
			tradeSectionPane(getReturnPane(), "Return");
		});
		
		returnCalButton.setOnMouseClicked(event->{
			tradeSectionPane(getReturnCalPane(), "Return Calculate");
		});			
		
		listButton.setOnMouseClicked(event->{
			tradeSectionPane(getListPane(), "List");
		});		

		userListButton.setOnMouseClicked(event->{
			tradeSectionPane(getUserListPane(), "User List");
		});		

		bookListButton.setOnMouseClicked(event->{
			tradeSectionPane(getBookListPane(), "Book List");
		});		

		borrowListButton.setOnMouseClicked(event->{
			tradeSectionPane(getBorrowListPane(), "Borrow List");
		});		
		
		/**
		 *  ------------------------------------ END CONFIG BUTTON TRADE PANE ------------------------------------
		 */
		
		
		/**
		 *  Configuração das funções do sistema biblioteca *******************************************************
		 */
		sendSignUpButton.setOnMouseClicked(event ->{
			
		});

		sendBookSignUpButton.setOnMouseClicked(event ->{
			
		});
		
		searchBook.setOnMouseClicked(event->{
			
		});
		
		searchUser.setOnMouseClicked(event->{
			
		});
		
		bookSearchButton.setOnMouseClicked(event->{
			
		});
		
		bookReturnButton.setOnMouseClicked(event->{
			
		});
		
		bookBorrowButton.setOnMouseClicked(event->{
			
		});
		
		/**
		 *  ----------------------- END LIBRARY FUNCTION BUTTON CONFIG ---------------------------------------------------
		 */
		
		//por default sessão principal terá o homepage como conteúdo
		Rectangle background = new Rectangle (WIDTH*5/6, HEIGHT*5/6, Color.WHITE);		
		principalSection.getChildren().add(background);
		principalSection.getChildren().add(getHomePane());
		
		
		/**
		 *  ------------------ FIM DO SETUP ESPECÍFICO DE SESSÕES ----------------------------------------------
		 */
		
		//Apresentação do Palco.
		primaryStage.show();
		
		//execução do gerenciador de fluxo da biblioteca
		LibraryManager manager = new LibraryManager();
		setLibraryManager(manager);
		new Thread (manager);
		
	} // start ()
	
} //class Library

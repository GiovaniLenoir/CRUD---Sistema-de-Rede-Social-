package com.redesocial.Main;

import com.redesocial.exception.UsuarioException;
import com.redesocial.gerenciador.GerenciadorPosts;
import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.uiMenuPrincipal.MenuPrincipal;

public class Main {
        public static void main(String[] args) throws UsuarioException {
            MenuPrincipal MenuPrincipal = new MenuPrincipal();
            MenuPrincipal.exibirMenu();
            GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
            GerenciadorPosts gerenciadorPosts = new GerenciadorPosts();

        }
        

}




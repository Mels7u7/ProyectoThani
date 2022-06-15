package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class prcgetmenu extends GXProcedure
{
   public prcgetmenu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( prcgetmenu.class ), "" );
   }

   public prcgetmenu( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.SdtSDTMenu> executeUdp( )
   {
      prcgetmenu.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.SdtSDTMenu>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.projectthani.SdtSDTMenu>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.projectthani.SdtSDTMenu>[] aP0 )
   {
      prcgetmenu.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Casa" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {})  );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Casa 1" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Casa 2" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://google.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Control deslizante de incio 1" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://twitter.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Nosotros" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( "https://doccure-html.dreamguystech.com/template/appointments.html" );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Tablero medico" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Equipo" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://google.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Pacientes" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( "#" );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Buscar doctor" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Reserva" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://google.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Farmacia" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( "#" );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Farmacia" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Producto" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://google.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Paginas" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( "#" );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Llamada de voz" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Videollamada" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://google.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Blog" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( "#" );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Lista de blogs" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Blod Grid" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://google.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      AV9MenuItem = (com.projectthani.SdtSDTMenu)new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV9MenuItem.setgxTv_SdtSDTMenu_Menutexto( "Administración" );
      AV9MenuItem.setgxTv_SdtSDTMenu_Menulink( "#" );
      AV10MenuSubNivel = (com.projectthani.SdtSDTMenu_SubMenusItem)new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menutexto( "Administración" );
      AV10MenuSubNivel.setgxTv_SdtSDTMenu_SubMenusItem_Menulink( "https://facebook.com" );
      AV9MenuItem.getgxTv_SdtSDTMenu_Submenus().add(AV10MenuSubNivel, 0);
      AV8Menu.add(AV9MenuItem, 0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = prcgetmenu.this.AV8Menu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Menu = new GXBaseCollection<com.projectthani.SdtSDTMenu>(com.projectthani.SdtSDTMenu.class, "SDTMenu", "ProjectThani", remoteHandle);
      AV9MenuItem = new com.projectthani.SdtSDTMenu(remoteHandle, context);
      AV10MenuSubNivel = new com.projectthani.SdtSDTMenu_SubMenusItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private GXBaseCollection<com.projectthani.SdtSDTMenu>[] aP0 ;
   private GXBaseCollection<com.projectthani.SdtSDTMenu> AV8Menu ;
   private com.projectthani.SdtSDTMenu AV9MenuItem ;
   private com.projectthani.SdtSDTMenu_SubMenusItem AV10MenuSubNivel ;
}


package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class menuoptionsdata extends GXProcedure
{
   public menuoptionsdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( menuoptionsdata.class ), "" );
   }

   public menuoptionsdata( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> executeUdp( short aP0 )
   {
      menuoptionsdata.this.aP1 = new GXBaseCollection[] {new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>()};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP1 )
   {
      menuoptionsdata.this.AV7SecRoleId = aP0;
      menuoptionsdata.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV5id = (short)(0) ;
      Gxm1dvelop_menu = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.projectthani.homepage", new String[] {}, new String[] {})  );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-home" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Inicio" );
      Gxm1dvelop_menu = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      Gxm2rootcol.add(Gxm1dvelop_menu, 0);
      AV5id = (short)(AV5id+1) ;
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-edit" );
      Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Menú Principal" );
      Gxv3skipcount = 0 ;
      AV16GXV2 = 1 ;
      GXt_objcol_SdtProgramNames_ProgramName1 = AV15GXV1 ;
      GXv_objcol_SdtProgramNames_ProgramName2[0] = GXt_objcol_SdtProgramNames_ProgramName1 ;
      new com.projectthani.wwpbaseobjects.listwwpprogramsthani(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName2) ;
      GXt_objcol_SdtProgramNames_ProgramName1 = GXv_objcol_SdtProgramNames_ProgramName2[0] ;
      AV15GXV1 = GXt_objcol_SdtProgramNames_ProgramName1 ;
      while ( AV16GXV2 <= AV15GXV1.size() )
      {
         AV6ProgramName = (com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName)((com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName)AV15GXV1.elementAt(-1+AV16GXV2));
         if ( AV7SecRoleId == 1 )
         {
            Gxv3skipcount = (int)(Gxv3skipcount+1) ;
            Gxm4dvelop_menu_subitems = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
            Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
            AV5id = (short)(AV5id+1) ;
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
            if ( ( 50 != 0 ) && ( Gxv3skipcount >= 50 ) )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         AV16GXV2 = (int)(AV16GXV2+1) ;
      }
      Gxv5skipcount = 0 ;
      AV18GXV4 = 1 ;
      GXt_objcol_SdtProgramNames_ProgramName1 = AV17GXV3 ;
      GXv_objcol_SdtProgramNames_ProgramName2[0] = GXt_objcol_SdtProgramNames_ProgramName1 ;
      new com.projectthani.wwpbaseobjects.listwwpprogramsthaniprofesional(remoteHandle, context).execute( GXv_objcol_SdtProgramNames_ProgramName2) ;
      GXt_objcol_SdtProgramNames_ProgramName1 = GXv_objcol_SdtProgramNames_ProgramName2[0] ;
      AV17GXV3 = GXt_objcol_SdtProgramNames_ProgramName1 ;
      while ( AV18GXV4 <= AV17GXV3.size() )
      {
         AV6ProgramName = (com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName)((com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName)AV17GXV3.elementAt(-1+AV18GXV4));
         if ( AV7SecRoleId == 2 )
         {
            Gxv5skipcount = (int)(Gxv5skipcount+1) ;
            Gxm4dvelop_menu_subitems = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
            Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
            AV5id = (short)(AV5id+1) ;
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Link() );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
            Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( AV6ProgramName.getgxTv_SdtProgramNames_ProgramName_Description() );
            if ( ( 20 != 0 ) && ( Gxv5skipcount >= 20 ) )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         AV18GXV4 = (int)(AV18GXV4+1) ;
      }
      if ( AV7SecRoleId == 1 )
      {
         Gxm1dvelop_menu = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm2rootcol.add(Gxm1dvelop_menu, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Tooltip( "Security of the application" );
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Link( "" );
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Iconclass( "menu-icon fa fa-key" );
         Gxm1dvelop_menu.setgxTv_SdtDVelop_Menu_Item_Caption( "Security" );
         Gxm4dvelop_menu_subitems = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "Users" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.projectthani.wwpbaseobjects.secuserww", new String[] {}, new String[] {})  );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Users" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
         Gxm4dvelop_menu_subitems = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "Roles" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.projectthani.wwpbaseobjects.secroleww", new String[] {}, new String[] {})  );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Roles" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Authorizationkey( "" );
         Gxm4dvelop_menu_subitems = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
         Gxm1dvelop_menu.getgxTv_SdtDVelop_Menu_Item_Subitems().add(Gxm4dvelop_menu_subitems, 0);
         AV5id = (short)(AV5id+1) ;
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Id( GXutil.str( AV5id, 4, 0) );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Tooltip( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Link( formatLink("com.projectthani.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {})  );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Linktarget( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Iconclass( "" );
         Gxm4dvelop_menu_subitems.setgxTv_SdtDVelop_Menu_Item_Caption( "Functionalities" );
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = menuoptionsdata.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>(com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "ProjectThani", remoteHandle);
      Gxm1dvelop_menu = new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV15GXV1 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>(com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "ProjectThani", remoteHandle);
      AV6ProgramName = new com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      Gxm4dvelop_menu_subitems = new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      AV17GXV3 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>(com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "ProjectThani", remoteHandle);
      GXt_objcol_SdtProgramNames_ProgramName1 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName>(com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "ProjectThani", remoteHandle);
      GXv_objcol_SdtProgramNames_ProgramName2 = new GXBaseCollection[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV7SecRoleId ;
   private short AV5id ;
   private short Gx_err ;
   private int Gxv3skipcount ;
   private int AV16GXV2 ;
   private int Gxv5skipcount ;
   private int AV18GXV4 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>[] aP1 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> AV15GXV1 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> AV17GXV3 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> GXt_objcol_SdtProgramNames_ProgramName1 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName> GXv_objcol_SdtProgramNames_ProgramName2[] ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> Gxm2rootcol ;
   private com.projectthani.wwpbaseobjects.SdtProgramNames_ProgramName AV6ProgramName ;
   private com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item Gxm1dvelop_menu ;
   private com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item Gxm4dvelop_menu_subitems ;
}


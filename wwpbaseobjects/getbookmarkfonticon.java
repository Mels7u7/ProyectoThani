package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getbookmarkfonticon extends GXProcedure
{
   public getbookmarkfonticon( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getbookmarkfonticon.class ), "" );
   }

   public getbookmarkfonticon( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> aP1 )
   {
      getbookmarkfonticon.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> aP1 ,
                             String[] aP2 )
   {
      getbookmarkfonticon.this.AV11LinkToFind = aP0;
      getbookmarkfonticon.this.AV9DVelop_Menu = aP1;
      getbookmarkfonticon.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV9DVelop_Menu.size() )
      {
         AV8DVelop_MenuItem = (com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)((com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item)AV9DVelop_Menu.elementAt(-1+AV16GXV1));
         if ( GXutil.strcmp(AV8DVelop_MenuItem.getgxTv_SdtDVelop_Menu_Item_Link(), AV11LinkToFind) == 0 )
         {
            AV10FontIcon = AV8DVelop_MenuItem.getgxTv_SdtDVelop_Menu_Item_Iconclass() ;
            if (true) break;
         }
         else
         {
            GXt_char1 = AV10FontIcon ;
            GXv_char2[0] = GXt_char1 ;
            new com.projectthani.wwpbaseobjects.getbookmarkfonticon(remoteHandle, context).execute( AV11LinkToFind, AV8DVelop_MenuItem.getgxTv_SdtDVelop_Menu_Item_Subitems(), GXv_char2) ;
            getbookmarkfonticon.this.GXt_char1 = GXv_char2[0] ;
            AV10FontIcon = GXt_char1 ;
            if ( GXutil.strcmp(AV10FontIcon, "") != 0 )
            {
               if (true) break;
            }
         }
         AV16GXV1 = (int)(AV16GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getbookmarkfonticon.this.AV10FontIcon;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10FontIcon = "" ;
      AV8DVelop_MenuItem = new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV16GXV1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV11LinkToFind ;
   private String AV10FontIcon ;
   private String[] aP2 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> AV9DVelop_Menu ;
   private com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item AV8DVelop_MenuItem ;
}


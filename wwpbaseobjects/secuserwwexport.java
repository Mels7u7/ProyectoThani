package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secuserwwexport extends GXProcedure
{
   public secuserwwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuserwwexport.class ), "" );
   }

   public secuserwwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secuserwwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      secuserwwexport.this.aP0 = aP0;
      secuserwwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser", GXv_boolean2) ;
      secuserwwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV61Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV47WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV47WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV13CellRow = 1 ;
         AV14FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S201 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S161 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV15Random = (int)(GXutil.random( )*10000) ;
      AV11Filename = "SecUserWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
      AV10ExcelDocument.Open(AV11Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV51FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Filter") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51FilterFullText, GXv_char7) ;
         secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV32TFSecUserId) && (0==AV33TFSecUserId_To) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Id") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setNumber( AV32TFSecUserId );
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV14FirstColumn+2), "Hasta") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+3, 1, 1).setNumber( AV33TFSecUserId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV35TFSecUserName_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Name") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV35TFSecUserName_Sel, GXv_char7) ;
         secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV34TFSecUserName)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Name") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV34TFSecUserName, GXv_char7) ;
            secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV53TFSecUserPassword_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Password") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV53TFSecUserPassword_Sel, GXv_char7) ;
         secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV52TFSecUserPassword)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Password") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFSecUserPassword, GXv_char7) ;
            secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV55TFSecUserEmail_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Correo") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV55TFSecUserEmail_Sel, GXv_char7) ;
         secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV54TFSecUserEmail)==0) ) )
         {
            GXv_exceldoc4[0] = AV10ExcelDocument ;
            GXv_int5[0] = (short)(AV13CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Correo") ;
            AV10ExcelDocument = GXv_exceldoc4[0] ;
            secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV54TFSecUserEmail, GXv_char7) ;
            secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV57TFSecUserEstadoR_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV10ExcelDocument ;
         GXv_int5[0] = (short)(AV13CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV14FirstColumn), "Estado R") ;
         AV10ExcelDocument = GXv_exceldoc4[0] ;
         secuserwwexport.this.AV13CellRow = GXv_int5[0] ;
         AV43i = 1 ;
         AV62GXV1 = 1 ;
         while ( AV62GXV1 <= AV57TFSecUserEstadoR_Sels.size() )
         {
            AV58TFSecUserEstadoR_Sel = (String)AV57TFSecUserEstadoR_Sels.elementAt(-1+AV62GXV1) ;
            if ( AV43i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestador.getDescription(httpContext,(String)AV58TFSecUserEstadoR_Sel) );
            AV43i = (long)(AV43i+1) ;
            AV62GXV1 = (int)(AV62GXV1+1) ;
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV44VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV38Session.getValue("WWPBaseObjects.SecUserWWColumnsSelector"), "") != 0 )
      {
         AV37ColumnsSelectorXML = AV38Session.getValue("WWPBaseObjects.SecUserWWColumnsSelector") ;
         AV36ColumnsSelector.fromxml(AV37ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV63GXV2 = 1 ;
      while ( AV63GXV2 <= AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV50ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV63GXV2));
         if ( AV50ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV50ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV50ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV50ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setColor( 11 );
            AV44VisibleColumnCount = (long)(AV44VisibleColumnCount+1) ;
         }
         AV63GXV2 = (int)(AV63GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV65Wwpbaseobjects_secuserwwds_1_filterfulltext = AV51FilterFullText ;
      AV66Wwpbaseobjects_secuserwwds_2_tfsecuserid = AV32TFSecUserId ;
      AV67Wwpbaseobjects_secuserwwds_3_tfsecuserid_to = AV33TFSecUserId_To ;
      AV68Wwpbaseobjects_secuserwwds_4_tfsecusername = AV34TFSecUserName ;
      AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = AV35TFSecUserName_Sel ;
      AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = AV52TFSecUserPassword ;
      AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = AV53TFSecUserPassword_Sel ;
      AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail = AV54TFSecUserEmail ;
      AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = AV55TFSecUserEmail_Sel ;
      AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = AV57TFSecUserEstadoR_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A211SecUserEstadoR ,
                                           AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                           AV65Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                           Short.valueOf(AV66Wwpbaseobjects_secuserwwds_2_tfsecuserid) ,
                                           Short.valueOf(AV67Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) ,
                                           AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                           AV68Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                           AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                           AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                           AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                           AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                           Integer.valueOf(AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels.size()) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           A15SecUserPassword ,
                                           A122SecUserEmail ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV65Wwpbaseobjects_secuserwwds_1_filterfulltext), "%", "") ;
      lV68Wwpbaseobjects_secuserwwds_4_tfsecusername = GXutil.concat( GXutil.rtrim( AV68Wwpbaseobjects_secuserwwds_4_tfsecusername), "%", "") ;
      lV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = GXutil.concat( GXutil.rtrim( AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword), "%", "") ;
      lV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail = GXutil.concat( GXutil.rtrim( AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail), "%", "") ;
      /* Using cursor P00292 */
      pr_default.execute(0, new Object[] {lV65Wwpbaseobjects_secuserwwds_1_filterfulltext, lV65Wwpbaseobjects_secuserwwds_1_filterfulltext, lV65Wwpbaseobjects_secuserwwds_1_filterfulltext, lV65Wwpbaseobjects_secuserwwds_1_filterfulltext, lV65Wwpbaseobjects_secuserwwds_1_filterfulltext, lV65Wwpbaseobjects_secuserwwds_1_filterfulltext, Short.valueOf(AV66Wwpbaseobjects_secuserwwds_2_tfsecuserid), Short.valueOf(AV67Wwpbaseobjects_secuserwwds_3_tfsecuserid_to), lV68Wwpbaseobjects_secuserwwds_4_tfsecusername, AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel, lV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword, AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel, lV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail, AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6SecUserId = P00292_A6SecUserId[0] ;
         A211SecUserEstadoR = P00292_A211SecUserEstadoR[0] ;
         A122SecUserEmail = P00292_A122SecUserEmail[0] ;
         A15SecUserPassword = P00292_A15SecUserPassword[0] ;
         A14SecUserName = P00292_A14SecUserName[0] ;
         AV13CellRow = (int)(AV13CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV44VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setNumber( A6SecUserId );
            AV44VisibleColumnCount = (long)(AV44VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A14SecUserName, GXv_char7) ;
            secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV44VisibleColumnCount = (long)(AV44VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A15SecUserPassword, GXv_char7) ;
            secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV44VisibleColumnCount = (long)(AV44VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A122SecUserEmail, GXv_char7) ;
            secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV44VisibleColumnCount = (long)(AV44VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV36ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV10ExcelDocument.Cells(AV13CellRow, (int)(AV14FirstColumn+AV44VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestador.getDescription(httpContext,(String)A211SecUserEstadoR) );
            AV44VisibleColumnCount = (long)(AV44VisibleColumnCount+1) ;
         }
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S182 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV10ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV10ExcelDocument.getErrCode() != 0 )
      {
         AV11Filename = "" ;
         AV12ErrorMessage = AV10ExcelDocument.getErrDescription() ;
         AV10ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV36ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV36ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserId", "", "Id", true, "") ;
      AV36ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV36ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserName", "", "Name", true, "") ;
      AV36ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV36ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserPassword", "", "Password", true, "") ;
      AV36ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV36ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserEmail", "", "Correo", true, "") ;
      AV36ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV36ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserEstadoR", "", "Estado R", true, "") ;
      AV36ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV39UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "WWPBaseObjects.SecUserWWColumnsSelector", GXv_char7) ;
      secuserwwexport.this.GXt_char6 = GXv_char7[0] ;
      AV39UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV39UserCustomValue)==0) ) )
      {
         AV49ColumnsSelectorAux.fromxml(AV39UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV49ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV36ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV49ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV36ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV38Session.getValue("WWPBaseObjects.SecUserWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV38Session.getValue("WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      AV16OrderedBy = AV30GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV17OrderedDsc = AV30GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV75GXV3 = 1 ;
      while ( AV75GXV3 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV48GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV75GXV3));
         if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV51FilterFullText = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV32TFSecUserId = (short)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV33TFSecUserId_To = (short)(GXutil.lval( AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV34TFSecUserName = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV35TFSecUserName_Sel = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPASSWORD") == 0 )
         {
            AV52TFSecUserPassword = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPASSWORD_SEL") == 0 )
         {
            AV53TFSecUserPassword_Sel = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSEREMAIL") == 0 )
         {
            AV54TFSecUserEmail = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSEREMAIL_SEL") == 0 )
         {
            AV55TFSecUserEmail_Sel = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERESTADOR_SEL") == 0 )
         {
            AV56TFSecUserEstadoR_SelsJson = AV48GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFSecUserEstadoR_Sels.fromJSonString(AV56TFSecUserEstadoR_SelsJson, null);
         }
         AV75GXV3 = (int)(AV75GXV3+1) ;
      }
   }

   public void S172( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S182( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = secuserwwexport.this.AV11Filename;
      this.aP1[0] = secuserwwexport.this.AV12ErrorMessage;
      CloseOpenCursors();
      AV10ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Filename = "" ;
      AV12ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV61Pgmname = "" ;
      AV47WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV51FilterFullText = "" ;
      AV35TFSecUserName_Sel = "" ;
      AV34TFSecUserName = "" ;
      AV53TFSecUserPassword_Sel = "" ;
      AV52TFSecUserPassword = "" ;
      AV55TFSecUserEmail_Sel = "" ;
      AV54TFSecUserEmail = "" ;
      AV57TFSecUserEstadoR_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV58TFSecUserEstadoR_Sel = "A" ;
      AV38Session = httpContext.getWebSession();
      AV37ColumnsSelectorXML = "" ;
      AV36ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV50ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A14SecUserName = "" ;
      A15SecUserPassword = "" ;
      A122SecUserEmail = "" ;
      A211SecUserEstadoR = "" ;
      AV65Wwpbaseobjects_secuserwwds_1_filterfulltext = "" ;
      AV68Wwpbaseobjects_secuserwwds_4_tfsecusername = "" ;
      AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel = "" ;
      AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = "" ;
      AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel = "" ;
      AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail = "" ;
      AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel = "" ;
      AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV65Wwpbaseobjects_secuserwwds_1_filterfulltext = "" ;
      lV68Wwpbaseobjects_secuserwwds_4_tfsecusername = "" ;
      lV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword = "" ;
      lV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail = "" ;
      P00292_A6SecUserId = new short[1] ;
      P00292_A211SecUserEstadoR = new String[] {""} ;
      P00292_A122SecUserEmail = new String[] {""} ;
      P00292_A15SecUserPassword = new String[] {""} ;
      P00292_A14SecUserName = new String[] {""} ;
      AV39UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV49ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV30GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV48GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV56TFSecUserEstadoR_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secuserwwexport__default(),
         new Object[] {
             new Object[] {
            P00292_A6SecUserId, P00292_A211SecUserEstadoR, P00292_A122SecUserEmail, P00292_A15SecUserPassword, P00292_A14SecUserName
            }
         }
      );
      AV61Pgmname = "WWPBaseObjects.SecUserWWExport" ;
      /* GeneXus formulas. */
      AV61Pgmname = "WWPBaseObjects.SecUserWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV32TFSecUserId ;
   private short AV33TFSecUserId_To ;
   private short GXv_int5[] ;
   private short A6SecUserId ;
   private short AV66Wwpbaseobjects_secuserwwds_2_tfsecuserid ;
   private short AV67Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ;
   private short AV16OrderedBy ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV62GXV1 ;
   private int AV63GXV2 ;
   private int AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ;
   private int AV75GXV3 ;
   private long AV43i ;
   private long AV44VisibleColumnCount ;
   private String AV61Pgmname ;
   private String AV58TFSecUserEstadoR_Sel ;
   private String A211SecUserEstadoR ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV17OrderedDsc ;
   private String AV37ColumnsSelectorXML ;
   private String AV39UserCustomValue ;
   private String AV56TFSecUserEstadoR_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV51FilterFullText ;
   private String AV35TFSecUserName_Sel ;
   private String AV34TFSecUserName ;
   private String AV53TFSecUserPassword_Sel ;
   private String AV52TFSecUserPassword ;
   private String AV55TFSecUserEmail_Sel ;
   private String AV54TFSecUserEmail ;
   private String A14SecUserName ;
   private String A15SecUserPassword ;
   private String A122SecUserEmail ;
   private String AV65Wwpbaseobjects_secuserwwds_1_filterfulltext ;
   private String AV68Wwpbaseobjects_secuserwwds_4_tfsecusername ;
   private String AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ;
   private String AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ;
   private String AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ;
   private String AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail ;
   private String AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ;
   private String lV65Wwpbaseobjects_secuserwwds_1_filterfulltext ;
   private String lV68Wwpbaseobjects_secuserwwds_4_tfsecusername ;
   private String lV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ;
   private String lV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail ;
   private com.genexus.webpanels.WebSession AV38Session ;
   private GXSimpleCollection<String> AV57TFSecUserEstadoR_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00292_A6SecUserId ;
   private String[] P00292_A211SecUserEstadoR ;
   private String[] P00292_A122SecUserEmail ;
   private String[] P00292_A15SecUserPassword ;
   private String[] P00292_A14SecUserName ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV47WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV48GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV36ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV49ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV50ColumnsSelector_Column ;
}

final  class secuserwwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00292( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A211SecUserEstadoR ,
                                          GXSimpleCollection<String> AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels ,
                                          String AV65Wwpbaseobjects_secuserwwds_1_filterfulltext ,
                                          short AV66Wwpbaseobjects_secuserwwds_2_tfsecuserid ,
                                          short AV67Wwpbaseobjects_secuserwwds_3_tfsecuserid_to ,
                                          String AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel ,
                                          String AV68Wwpbaseobjects_secuserwwds_4_tfsecusername ,
                                          String AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel ,
                                          String AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword ,
                                          String AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel ,
                                          String AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail ,
                                          int AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          String A15SecUserPassword ,
                                          String A122SecUserEmail ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[14];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [SecUserId], [SecUserEstadoR], [SecUserEmail], [SecUserPassword], [SecUserName] FROM [SecUser]" ;
      if ( ! (GXutil.strcmp("", AV65Wwpbaseobjects_secuserwwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([SecUserId] AS decimal(4,0))) like '%' + ?) or ( [SecUserName] like '%' + ?) or ( [SecUserPassword] like '%' + ?) or ( [SecUserEmail] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [SecUserEstadoR] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [SecUserEstadoR] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV66Wwpbaseobjects_secuserwwds_2_tfsecuserid) )
      {
         addWhere(sWhereString, "([SecUserId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Wwpbaseobjects_secuserwwds_3_tfsecuserid_to) )
      {
         addWhere(sWhereString, "([SecUserId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV68Wwpbaseobjects_secuserwwds_4_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "([SecUserName] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Wwpbaseobjects_secuserwwds_5_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserName] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) && ( ! (GXutil.strcmp("", AV70Wwpbaseobjects_secuserwwds_6_tfsecuserpassword)==0) ) )
      {
         addWhere(sWhereString, "([SecUserPassword] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Wwpbaseobjects_secuserwwds_7_tfsecuserpassword_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserPassword] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) && ( ! (GXutil.strcmp("", AV72Wwpbaseobjects_secuserwwds_8_tfsecuseremail)==0) ) )
      {
         addWhere(sWhereString, "([SecUserEmail] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Wwpbaseobjects_secuserwwds_9_tfsecuseremail_sel)==0) )
      {
         addWhere(sWhereString, "([SecUserEmail] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV74Wwpbaseobjects_secuserwwds_10_tfsecuserestador_sels, "[SecUserEstadoR] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserName]" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserName] DESC" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserId]" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserId] DESC" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserPassword]" ;
      }
      else if ( ( AV16OrderedBy == 3 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserPassword] DESC" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserEmail]" ;
      }
      else if ( ( AV16OrderedBy == 4 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserEmail] DESC" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY [SecUserEstadoR]" ;
      }
      else if ( ( AV16OrderedBy == 5 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [SecUserEstadoR] DESC" ;
      }
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00292(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00292", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[19], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[21]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[22], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               return;
      }
   }

}


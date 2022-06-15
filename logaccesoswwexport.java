package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class logaccesoswwexport extends GXProcedure
{
   public logaccesoswwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logaccesoswwexport.class ), "" );
   }

   public logaccesoswwexport( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      logaccesoswwexport.this.aP1 = new String[] {""};
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
      logaccesoswwexport.this.aP0 = aP0;
      logaccesoswwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos", GXv_boolean2) ;
      logaccesoswwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV55Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV14CellRow = 1 ;
         AV15FirstColumn = 1 ;
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
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "LogAccesosWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV19FilterFullText)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Filter") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFLogAccesosId) && (0==AV36TFLogAccesosId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Log Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFLogAccesosId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFLogAccesosId_To );
      }
      if ( ! ( (0==AV37TFSecUserId) && (0==AV38TFSecUserId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "User Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV37TFSecUserId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV38TFSecUserId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV40TFSecUserName_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "User Name") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFSecUserName_Sel, GXv_char7) ;
         logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFSecUserName)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "User Name") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFSecUserName, GXv_char7) ;
            logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV41TFSecRoleId) && (0==AV42TFSecRoleId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Role Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFSecRoleId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFSecRoleId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV44TFSecRoleDescription_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Role Description") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFSecRoleDescription_Sel, GXv_char7) ;
         logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFSecRoleDescription)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Role Description") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFSecRoleDescription, GXv_char7) ;
            logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFLogAccesosFullName_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombres Completos") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFLogAccesosFullName_Sel, GXv_char7) ;
         logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFLogAccesosFullName)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombres Completos") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFLogAccesosFullName, GXv_char7) ;
            logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV48TFLogAccesosTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV52i = 1 ;
         AV56GXV1 = 1 ;
         while ( AV56GXV1 <= AV48TFLogAccesosTipo_Sels.size() )
         {
            AV49TFLogAccesosTipo_Sel = (String)AV48TFLogAccesosTipo_Sels.elementAt(-1+AV56GXV1) ;
            if ( AV52i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipoacceso.getDescription(httpContext,(String)AV49TFLogAccesosTipo_Sel) );
            AV52i = (long)(AV52i+1) ;
            AV56GXV1 = (int)(AV56GXV1+1) ;
         }
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), AV50TFLogAccesosFecha) && GXutil.dateCompare(GXutil.nullDate(), AV51TFLogAccesosFecha_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Fecha") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setDate( AV50TFLogAccesosFecha );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         logaccesoswwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setDate( AV51TFLogAccesosFecha_To );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("LogAccesosWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("LogAccesosWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV57GXV2 = 1 ;
      while ( AV57GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV57GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV57GXV2 = (int)(AV57GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV59Logaccesoswwds_1_filterfulltext = AV19FilterFullText ;
      AV60Logaccesoswwds_2_tflogaccesosid = AV35TFLogAccesosId ;
      AV61Logaccesoswwds_3_tflogaccesosid_to = AV36TFLogAccesosId_To ;
      AV62Logaccesoswwds_4_tfsecuserid = AV37TFSecUserId ;
      AV63Logaccesoswwds_5_tfsecuserid_to = AV38TFSecUserId_To ;
      AV64Logaccesoswwds_6_tfsecusername = AV39TFSecUserName ;
      AV65Logaccesoswwds_7_tfsecusername_sel = AV40TFSecUserName_Sel ;
      AV66Logaccesoswwds_8_tfsecroleid = AV41TFSecRoleId ;
      AV67Logaccesoswwds_9_tfsecroleid_to = AV42TFSecRoleId_To ;
      AV68Logaccesoswwds_10_tfsecroledescription = AV43TFSecRoleDescription ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = AV44TFSecRoleDescription_Sel ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = AV45TFLogAccesosFullName ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = AV46TFLogAccesosFullName_Sel ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = AV48TFLogAccesosTipo_Sels ;
      AV73Logaccesoswwds_15_tflogaccesosfecha = AV50TFLogAccesosFecha ;
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = AV51TFLogAccesosFecha_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A227LogAccesosTipo ,
                                           AV72Logaccesoswwds_14_tflogaccesostipo_sels ,
                                           Short.valueOf(AV60Logaccesoswwds_2_tflogaccesosid) ,
                                           Short.valueOf(AV61Logaccesoswwds_3_tflogaccesosid_to) ,
                                           Short.valueOf(AV62Logaccesoswwds_4_tfsecuserid) ,
                                           Short.valueOf(AV63Logaccesoswwds_5_tfsecuserid_to) ,
                                           AV65Logaccesoswwds_7_tfsecusername_sel ,
                                           AV64Logaccesoswwds_6_tfsecusername ,
                                           Short.valueOf(AV66Logaccesoswwds_8_tfsecroleid) ,
                                           Short.valueOf(AV67Logaccesoswwds_9_tfsecroleid_to) ,
                                           AV69Logaccesoswwds_11_tfsecroledescription_sel ,
                                           AV68Logaccesoswwds_10_tfsecroledescription ,
                                           Integer.valueOf(AV72Logaccesoswwds_14_tflogaccesostipo_sels.size()) ,
                                           AV73Logaccesoswwds_15_tflogaccesosfecha ,
                                           AV74Logaccesoswwds_16_tflogaccesosfecha_to ,
                                           Short.valueOf(A41LogAccesosId) ,
                                           Short.valueOf(A6SecUserId) ,
                                           A14SecUserName ,
                                           Short.valueOf(A4SecRoleId) ,
                                           A12SecRoleDescription ,
                                           A228LogAccesosFecha ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           AV59Logaccesoswwds_1_filterfulltext ,
                                           A172LogAccesosFullName ,
                                           AV71Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                           AV70Logaccesoswwds_12_tflogaccesosfullname } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV64Logaccesoswwds_6_tfsecusername = GXutil.concat( GXutil.rtrim( AV64Logaccesoswwds_6_tfsecusername), "%", "") ;
      lV68Logaccesoswwds_10_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV68Logaccesoswwds_10_tfsecroledescription), "%", "") ;
      /* Using cursor P00472 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV60Logaccesoswwds_2_tflogaccesosid), Short.valueOf(AV61Logaccesoswwds_3_tflogaccesosid_to), Short.valueOf(AV62Logaccesoswwds_4_tfsecuserid), Short.valueOf(AV63Logaccesoswwds_5_tfsecuserid_to), lV64Logaccesoswwds_6_tfsecusername, AV65Logaccesoswwds_7_tfsecusername_sel, Short.valueOf(AV66Logaccesoswwds_8_tfsecroleid), Short.valueOf(AV67Logaccesoswwds_9_tfsecroleid_to), lV68Logaccesoswwds_10_tfsecroledescription, AV69Logaccesoswwds_11_tfsecroledescription_sel, AV73Logaccesoswwds_15_tflogaccesosfecha, AV74Logaccesoswwds_16_tflogaccesosfecha_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A228LogAccesosFecha = P00472_A228LogAccesosFecha[0] ;
         A6SecUserId = P00472_A6SecUserId[0] ;
         A41LogAccesosId = P00472_A41LogAccesosId[0] ;
         A227LogAccesosTipo = P00472_A227LogAccesosTipo[0] ;
         A12SecRoleDescription = P00472_A12SecRoleDescription[0] ;
         A14SecUserName = P00472_A14SecUserName[0] ;
         A4SecRoleId = P00472_A4SecRoleId[0] ;
         A14SecUserName = P00472_A14SecUserName[0] ;
         A12SecRoleDescription = P00472_A12SecRoleDescription[0] ;
         GXt_char6 = A172LogAccesosFullName ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char7) ;
         logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
         A172LogAccesosFullName = GXt_char6 ;
         if ( (GXutil.strcmp("", AV59Logaccesoswwds_1_filterfulltext)==0) || ( ( GXutil.like( GXutil.str( A41LogAccesosId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A6SecUserId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A14SecUserName , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( GXutil.str( A4SecRoleId, 4, 0) , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 254 , "%"),  ' ' ) ) || ( GXutil.like( A12SecRoleDescription , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 120 , "%"),  ' ' ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( "%" + AV59Logaccesoswwds_1_filterfulltext , 101 , "%"),  ' ' ) ) || ( GXutil.like( "ingreso" , GXutil.padr( "%" + GXutil.lower( AV59Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) ) || ( GXutil.like( "salida" , GXutil.padr( "%" + GXutil.lower( AV59Logaccesoswwds_1_filterfulltext) , 255 , "%"),  ' ' ) && ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) ) )
         {
            if ( ! ( (GXutil.strcmp("", AV71Logaccesoswwds_13_tflogaccesosfullname_sel)==0) && ( ! (GXutil.strcmp("", AV70Logaccesoswwds_12_tflogaccesosfullname)==0) ) ) || ( GXutil.like( A172LogAccesosFullName , GXutil.padr( AV70Logaccesoswwds_12_tflogaccesosfullname , 100 , "%"),  ' ' ) ) )
            {
               if ( (GXutil.strcmp("", AV71Logaccesoswwds_13_tflogaccesosfullname_sel)==0) || ( ( GXutil.strcmp(A172LogAccesosFullName, AV71Logaccesoswwds_13_tflogaccesosfullname_sel) == 0 ) ) )
               {
                  AV14CellRow = (int)(AV14CellRow+1) ;
                  /* Execute user subroutine: 'BEFOREWRITELINE' */
                  S172 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     if (true) return;
                  }
                  AV32VisibleColumnCount = 0 ;
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A41LogAccesosId );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A6SecUserId );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     GXt_char6 = "" ;
                     GXv_char7[0] = GXt_char6 ;
                     new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A14SecUserName, GXv_char7) ;
                     logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A4SecRoleId );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     GXt_char6 = "" ;
                     GXv_char7[0] = GXt_char6 ;
                     new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A12SecRoleDescription, GXv_char7) ;
                     logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     GXt_char6 = "" ;
                     GXv_char7[0] = GXt_char6 ;
                     new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A172LogAccesosFullName, GXv_char7) ;
                     logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipoacceso.getDescription(httpContext,(String)A227LogAccesosTipo) );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
                  {
                     AV11ExcelDocument.setDateFormat(localUtil, 8, 5, 0, 3, "/", ":", " ");
                     AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setDate( A228LogAccesosFecha );
                     AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
                  }
                  /* Execute user subroutine: 'AFTERWRITELINE' */
                  S182 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     pr_default.close(0);
                     pr_default.close(0);
                     returnInSub = true;
                     if (true) return;
                  }
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S191( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'INITIALIZECOLUMNSSELECTOR' Routine */
      returnInSub = false ;
      AV24ColumnsSelector = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector)new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LogAccesosId", "", "Log Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserId", "", "User Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecUserName", "", "User Name", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecRoleId", "", "Role Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SecRoleDescription", "", "Role Description", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LogAccesosFullName", "", "Nombres Completos", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LogAccesosTipo", "", "Tipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "LogAccesosFecha", "", "Fecha", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "LogAccesosWWColumnsSelector", GXv_char7) ;
      logaccesoswwexport.this.GXt_char6 = GXv_char7[0] ;
      AV28UserCustomValue = GXt_char6 ;
      if ( ! ( (GXutil.strcmp("", AV28UserCustomValue)==0) ) )
      {
         AV25ColumnsSelectorAux.fromxml(AV28UserCustomValue, null, null);
         GXv_SdtWWPColumnsSelector8[0] = AV25ColumnsSelectorAux;
         GXv_SdtWWPColumnsSelector9[0] = AV24ColumnsSelector;
         new com.projectthani.wwpbaseobjects.wwp_columnselector_updatecolumns(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, GXv_SdtWWPColumnsSelector9) ;
         AV25ColumnsSelectorAux = GXv_SdtWWPColumnsSelector8[0] ;
         AV24ColumnsSelector = GXv_SdtWWPColumnsSelector9[0] ;
      }
   }

   public void S201( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("LogAccesosWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LogAccesosWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("LogAccesosWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV75GXV3 = 1 ;
      while ( AV75GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV75GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSID") == 0 )
         {
            AV35TFLogAccesosId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFLogAccesosId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERID") == 0 )
         {
            AV37TFSecUserId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV38TFSecUserId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME") == 0 )
         {
            AV39TFSecUserName = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERNAME_SEL") == 0 )
         {
            AV40TFSecUserName_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEID") == 0 )
         {
            AV41TFSecRoleId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV42TFSecRoleId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV43TFSecRoleDescription = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV44TFSecRoleDescription_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME") == 0 )
         {
            AV45TFLogAccesosFullName = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFULLNAME_SEL") == 0 )
         {
            AV46TFLogAccesosFullName_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSTIPO_SEL") == 0 )
         {
            AV47TFLogAccesosTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFLogAccesosTipo_Sels.fromJSonString(AV47TFLogAccesosTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLOGACCESOSFECHA") == 0 )
         {
            AV50TFLogAccesosFecha = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            AV51TFLogAccesosFecha_To = localUtil.ctot( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
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
      this.aP0[0] = logaccesoswwexport.this.AV12Filename;
      this.aP1[0] = logaccesoswwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV55Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV40TFSecUserName_Sel = "" ;
      AV39TFSecUserName = "" ;
      AV44TFSecRoleDescription_Sel = "" ;
      AV43TFSecRoleDescription = "" ;
      AV46TFLogAccesosFullName_Sel = "" ;
      AV45TFLogAccesosFullName = "" ;
      AV48TFLogAccesosTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFLogAccesosTipo_Sel = "" ;
      AV50TFLogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      AV51TFLogAccesosFecha_To = GXutil.resetTime( GXutil.nullDate() );
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A14SecUserName = "" ;
      A12SecRoleDescription = "" ;
      A172LogAccesosFullName = "" ;
      A227LogAccesosTipo = "" ;
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      AV59Logaccesoswwds_1_filterfulltext = "" ;
      AV64Logaccesoswwds_6_tfsecusername = "" ;
      AV65Logaccesoswwds_7_tfsecusername_sel = "" ;
      AV68Logaccesoswwds_10_tfsecroledescription = "" ;
      AV69Logaccesoswwds_11_tfsecroledescription_sel = "" ;
      AV70Logaccesoswwds_12_tflogaccesosfullname = "" ;
      AV71Logaccesoswwds_13_tflogaccesosfullname_sel = "" ;
      AV72Logaccesoswwds_14_tflogaccesostipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV73Logaccesoswwds_15_tflogaccesosfecha = GXutil.resetTime( GXutil.nullDate() );
      AV74Logaccesoswwds_16_tflogaccesosfecha_to = GXutil.resetTime( GXutil.nullDate() );
      lV59Logaccesoswwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV64Logaccesoswwds_6_tfsecusername = "" ;
      lV68Logaccesoswwds_10_tfsecroledescription = "" ;
      P00472_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P00472_A6SecUserId = new short[1] ;
      P00472_A41LogAccesosId = new short[1] ;
      P00472_A227LogAccesosTipo = new String[] {""} ;
      P00472_A12SecRoleDescription = new String[] {""} ;
      P00472_A14SecUserName = new String[] {""} ;
      P00472_A4SecRoleId = new short[1] ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV47TFLogAccesosTipo_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesoswwexport__default(),
         new Object[] {
             new Object[] {
            P00472_A228LogAccesosFecha, P00472_A6SecUserId, P00472_A41LogAccesosId, P00472_A227LogAccesosTipo, P00472_A12SecRoleDescription, P00472_A14SecUserName, P00472_A4SecRoleId
            }
         }
      );
      AV55Pgmname = "LogAccesosWWExport" ;
      /* GeneXus formulas. */
      AV55Pgmname = "LogAccesosWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFLogAccesosId ;
   private short AV36TFLogAccesosId_To ;
   private short AV37TFSecUserId ;
   private short AV38TFSecUserId_To ;
   private short AV41TFSecRoleId ;
   private short AV42TFSecRoleId_To ;
   private short GXv_int5[] ;
   private short A41LogAccesosId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV60Logaccesoswwds_2_tflogaccesosid ;
   private short AV61Logaccesoswwds_3_tflogaccesosid_to ;
   private short AV62Logaccesoswwds_4_tfsecuserid ;
   private short AV63Logaccesoswwds_5_tfsecuserid_to ;
   private short AV66Logaccesoswwds_8_tfsecroleid ;
   private short AV67Logaccesoswwds_9_tfsecroleid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV56GXV1 ;
   private int AV57GXV2 ;
   private int AV72Logaccesoswwds_14_tflogaccesostipo_sels_size ;
   private int AV75GXV3 ;
   private long AV52i ;
   private long AV32VisibleColumnCount ;
   private String AV55Pgmname ;
   private String AV49TFLogAccesosTipo_Sel ;
   private String A227LogAccesosTipo ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date AV50TFLogAccesosFecha ;
   private java.util.Date AV51TFLogAccesosFecha_To ;
   private java.util.Date A228LogAccesosFecha ;
   private java.util.Date AV73Logaccesoswwds_15_tflogaccesosfecha ;
   private java.util.Date AV74Logaccesoswwds_16_tflogaccesosfecha_to ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV47TFLogAccesosTipo_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV40TFSecUserName_Sel ;
   private String AV39TFSecUserName ;
   private String AV44TFSecRoleDescription_Sel ;
   private String AV43TFSecRoleDescription ;
   private String AV46TFLogAccesosFullName_Sel ;
   private String AV45TFLogAccesosFullName ;
   private String A14SecUserName ;
   private String A12SecRoleDescription ;
   private String A172LogAccesosFullName ;
   private String AV59Logaccesoswwds_1_filterfulltext ;
   private String AV64Logaccesoswwds_6_tfsecusername ;
   private String AV65Logaccesoswwds_7_tfsecusername_sel ;
   private String AV68Logaccesoswwds_10_tfsecroledescription ;
   private String AV69Logaccesoswwds_11_tfsecroledescription_sel ;
   private String AV70Logaccesoswwds_12_tflogaccesosfullname ;
   private String AV71Logaccesoswwds_13_tflogaccesosfullname_sel ;
   private String lV59Logaccesoswwds_1_filterfulltext ;
   private String lV64Logaccesoswwds_6_tfsecusername ;
   private String lV68Logaccesoswwds_10_tfsecroledescription ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV48TFLogAccesosTipo_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00472_A228LogAccesosFecha ;
   private short[] P00472_A6SecUserId ;
   private short[] P00472_A41LogAccesosId ;
   private String[] P00472_A227LogAccesosTipo ;
   private String[] P00472_A12SecRoleDescription ;
   private String[] P00472_A14SecUserName ;
   private short[] P00472_A4SecRoleId ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV72Logaccesoswwds_14_tflogaccesostipo_sels ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV24ColumnsSelector ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector AV25ColumnsSelectorAux ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector8[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector GXv_SdtWWPColumnsSelector9[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column AV26ColumnsSelector_Column ;
}

final  class logaccesoswwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00472( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A227LogAccesosTipo ,
                                          GXSimpleCollection<String> AV72Logaccesoswwds_14_tflogaccesostipo_sels ,
                                          short AV60Logaccesoswwds_2_tflogaccesosid ,
                                          short AV61Logaccesoswwds_3_tflogaccesosid_to ,
                                          short AV62Logaccesoswwds_4_tfsecuserid ,
                                          short AV63Logaccesoswwds_5_tfsecuserid_to ,
                                          String AV65Logaccesoswwds_7_tfsecusername_sel ,
                                          String AV64Logaccesoswwds_6_tfsecusername ,
                                          short AV66Logaccesoswwds_8_tfsecroleid ,
                                          short AV67Logaccesoswwds_9_tfsecroleid_to ,
                                          String AV69Logaccesoswwds_11_tfsecroledescription_sel ,
                                          String AV68Logaccesoswwds_10_tfsecroledescription ,
                                          int AV72Logaccesoswwds_14_tflogaccesostipo_sels_size ,
                                          java.util.Date AV73Logaccesoswwds_15_tflogaccesosfecha ,
                                          java.util.Date AV74Logaccesoswwds_16_tflogaccesosfecha_to ,
                                          short A41LogAccesosId ,
                                          short A6SecUserId ,
                                          String A14SecUserName ,
                                          short A4SecRoleId ,
                                          String A12SecRoleDescription ,
                                          java.util.Date A228LogAccesosFecha ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          String AV59Logaccesoswwds_1_filterfulltext ,
                                          String A172LogAccesosFullName ,
                                          String AV71Logaccesoswwds_13_tflogaccesosfullname_sel ,
                                          String AV70Logaccesoswwds_12_tflogaccesosfullname )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[12];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T1.[LogAccesosFecha], T1.[SecUserId], T1.[LogAccesosId], T1.[LogAccesosTipo], T3.[SecRoleDescription], T2.[SecUserName], T1.[SecRoleId] FROM (([LogAccesos]" ;
      scmdbuf += " T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = T1.[SecRoleId])" ;
      if ( ! (0==AV60Logaccesoswwds_2_tflogaccesosid) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] >= ?)");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
      }
      if ( ! (0==AV61Logaccesoswwds_3_tflogaccesosid_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosId] <= ?)");
      }
      else
      {
         GXv_int10[1] = (byte)(1) ;
      }
      if ( ! (0==AV62Logaccesoswwds_4_tfsecuserid) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] >= ?)");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( ! (0==AV63Logaccesoswwds_5_tfsecuserid_to) )
      {
         addWhere(sWhereString, "(T1.[SecUserId] <= ?)");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Logaccesoswwds_7_tfsecusername_sel)==0) && ( ! (GXutil.strcmp("", AV64Logaccesoswwds_6_tfsecusername)==0) ) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] like ?)");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Logaccesoswwds_7_tfsecusername_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[SecUserName] = ?)");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( ! (0==AV66Logaccesoswwds_8_tfsecroleid) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] >= ?)");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Logaccesoswwds_9_tfsecroleid_to) )
      {
         addWhere(sWhereString, "(T1.[SecRoleId] <= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Logaccesoswwds_11_tfsecroledescription_sel)==0) && ( ! (GXutil.strcmp("", AV68Logaccesoswwds_10_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] like ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Logaccesoswwds_11_tfsecroledescription_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[SecRoleDescription] = ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( AV72Logaccesoswwds_14_tflogaccesostipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV72Logaccesoswwds_14_tflogaccesostipo_sels, "T1.[LogAccesosTipo] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV73Logaccesoswwds_15_tflogaccesosfecha) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] >= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV74Logaccesoswwds_16_tflogaccesosfecha_to) )
      {
         addWhere(sWhereString, "(T1.[LogAccesosFecha] <= ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecUserId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecUserId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[SecUserName]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[SecUserName] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SecRoleId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[SecRoleDescription] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosTipo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[LogAccesosFecha] DESC" ;
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
                  return conditional_P00472(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] , (java.util.Date)dynConstraints[14] , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).shortValue() , (String)dynConstraints[19] , (java.util.Date)dynConstraints[20] , ((Number) dynConstraints[21]).shortValue() , ((Boolean) dynConstraints[22]).booleanValue() , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00472", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
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
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[20], 120);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[21], 120);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[22], false);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[23], false);
               }
               return;
      }
   }

}


package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class drogueriawwexport extends GXProcedure
{
   public drogueriawwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( drogueriawwexport.class ), "" );
   }

   public drogueriawwexport( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      drogueriawwexport.this.aP1 = new String[] {""};
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
      drogueriawwexport.this.aP0 = aP0;
      drogueriawwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria", GXv_boolean2) ;
      drogueriawwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV54Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "DrogueriaWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFDrogueriaId) && (0==AV36TFDrogueriaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFDrogueriaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFDrogueriaId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFDrogueriaNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFDrogueriaNombre_Sel, GXv_char7) ;
         drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFDrogueriaNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFDrogueriaNombre, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFDrogueriaDescripcion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFDrogueriaDescripcion_Sel, GXv_char7) ;
         drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFDrogueriaDescripcion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Descripcion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFDrogueriaDescripcion, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV42TFDrogueriaTipoDocumento_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV55GXV1 = 1 ;
         while ( AV55GXV1 <= AV42TFDrogueriaTipoDocumento_Sels.size() )
         {
            AV43TFDrogueriaTipoDocumento_Sel = (String)AV42TFDrogueriaTipoDocumento_Sels.elementAt(-1+AV55GXV1) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)AV43TFDrogueriaTipoDocumento_Sel) );
            AV51i = (long)(AV51i+1) ;
            AV55GXV1 = (int)(AV55GXV1+1) ;
         }
      }
      if ( ! ( (GXutil.strcmp("", AV45TFDrogueriaNroDocumento_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFDrogueriaNroDocumento_Sel, GXv_char7) ;
         drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV44TFDrogueriaNroDocumento)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nro Documento") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFDrogueriaNroDocumento, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV47TFDrogueriaDireccion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFDrogueriaDireccion_Sel, GXv_char7) ;
         drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV46TFDrogueriaDireccion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFDrogueriaDireccion, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV49TFDrogueriaEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         drogueriawwexport.this.AV14CellRow = GXv_int5[0] ;
         AV51i = 1 ;
         AV56GXV2 = 1 ;
         while ( AV56GXV2 <= AV49TFDrogueriaEstado_Sels.size() )
         {
            AV50TFDrogueriaEstado_Sel = (String)AV49TFDrogueriaEstado_Sels.elementAt(-1+AV56GXV2) ;
            if ( AV51i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV50TFDrogueriaEstado_Sel) );
            AV51i = (long)(AV51i+1) ;
            AV56GXV2 = (int)(AV56GXV2+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("DrogueriaWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("DrogueriaWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV57GXV3 = 1 ;
      while ( AV57GXV3 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV57GXV3));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV57GXV3 = (int)(AV57GXV3+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV59Drogueriawwds_1_filterfulltext = AV19FilterFullText ;
      AV60Drogueriawwds_2_tfdrogueriaid = AV35TFDrogueriaId ;
      AV61Drogueriawwds_3_tfdrogueriaid_to = AV36TFDrogueriaId_To ;
      AV62Drogueriawwds_4_tfdroguerianombre = AV37TFDrogueriaNombre ;
      AV63Drogueriawwds_5_tfdroguerianombre_sel = AV38TFDrogueriaNombre_Sel ;
      AV64Drogueriawwds_6_tfdrogueriadescripcion = AV39TFDrogueriaDescripcion ;
      AV65Drogueriawwds_7_tfdrogueriadescripcion_sel = AV40TFDrogueriaDescripcion_Sel ;
      AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels = AV42TFDrogueriaTipoDocumento_Sels ;
      AV67Drogueriawwds_9_tfdroguerianrodocumento = AV44TFDrogueriaNroDocumento ;
      AV68Drogueriawwds_10_tfdroguerianrodocumento_sel = AV45TFDrogueriaNroDocumento_Sel ;
      AV69Drogueriawwds_11_tfdrogueriadireccion = AV46TFDrogueriaDireccion ;
      AV70Drogueriawwds_12_tfdrogueriadireccion_sel = AV47TFDrogueriaDireccion_Sel ;
      AV71Drogueriawwds_13_tfdrogueriaestado_sels = AV49TFDrogueriaEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A143DrogueriaTipoDocumento ,
                                           AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                           A147DrogueriaEstado ,
                                           AV71Drogueriawwds_13_tfdrogueriaestado_sels ,
                                           AV59Drogueriawwds_1_filterfulltext ,
                                           Short.valueOf(AV60Drogueriawwds_2_tfdrogueriaid) ,
                                           Short.valueOf(AV61Drogueriawwds_3_tfdrogueriaid_to) ,
                                           AV63Drogueriawwds_5_tfdroguerianombre_sel ,
                                           AV62Drogueriawwds_4_tfdroguerianombre ,
                                           AV65Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                           AV64Drogueriawwds_6_tfdrogueriadescripcion ,
                                           Integer.valueOf(AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels.size()) ,
                                           AV68Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                           AV67Drogueriawwds_9_tfdroguerianrodocumento ,
                                           AV70Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                           AV69Drogueriawwds_11_tfdrogueriadireccion ,
                                           Integer.valueOf(AV71Drogueriawwds_13_tfdrogueriaestado_sels.size()) ,
                                           Short.valueOf(A36DrogueriaId) ,
                                           A141DrogueriaNombre ,
                                           A142DrogueriaDescripcion ,
                                           A144DrogueriaNroDocumento ,
                                           A145DrogueriaDireccion ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV59Drogueriawwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV59Drogueriawwds_1_filterfulltext), "%", "") ;
      lV62Drogueriawwds_4_tfdroguerianombre = GXutil.concat( GXutil.rtrim( AV62Drogueriawwds_4_tfdroguerianombre), "%", "") ;
      lV64Drogueriawwds_6_tfdrogueriadescripcion = GXutil.concat( GXutil.rtrim( AV64Drogueriawwds_6_tfdrogueriadescripcion), "%", "") ;
      lV67Drogueriawwds_9_tfdroguerianrodocumento = GXutil.concat( GXutil.rtrim( AV67Drogueriawwds_9_tfdroguerianrodocumento), "%", "") ;
      lV69Drogueriawwds_11_tfdrogueriadireccion = GXutil.concat( GXutil.rtrim( AV69Drogueriawwds_11_tfdrogueriadireccion), "%", "") ;
      /* Using cursor P004L2 */
      pr_default.execute(0, new Object[] {lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, lV59Drogueriawwds_1_filterfulltext, Short.valueOf(AV60Drogueriawwds_2_tfdrogueriaid), Short.valueOf(AV61Drogueriawwds_3_tfdrogueriaid_to), lV62Drogueriawwds_4_tfdroguerianombre, AV63Drogueriawwds_5_tfdroguerianombre_sel, lV64Drogueriawwds_6_tfdrogueriadescripcion, AV65Drogueriawwds_7_tfdrogueriadescripcion_sel, lV67Drogueriawwds_9_tfdroguerianrodocumento, AV68Drogueriawwds_10_tfdroguerianrodocumento_sel, lV69Drogueriawwds_11_tfdrogueriadireccion, AV70Drogueriawwds_12_tfdrogueriadireccion_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A36DrogueriaId = P004L2_A36DrogueriaId[0] ;
         A147DrogueriaEstado = P004L2_A147DrogueriaEstado[0] ;
         A145DrogueriaDireccion = P004L2_A145DrogueriaDireccion[0] ;
         A144DrogueriaNroDocumento = P004L2_A144DrogueriaNroDocumento[0] ;
         A143DrogueriaTipoDocumento = P004L2_A143DrogueriaTipoDocumento[0] ;
         A142DrogueriaDescripcion = P004L2_A142DrogueriaDescripcion[0] ;
         A141DrogueriaNombre = P004L2_A141DrogueriaNombre[0] ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV32VisibleColumnCount = 0 ;
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+1)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A36DrogueriaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A141DrogueriaNombre, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A142DrogueriaDescripcion, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintipodocumento.getDescription(httpContext,(String)A143DrogueriaTipoDocumento) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A144DrogueriaNroDocumento, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A145DrogueriaDireccion, GXv_char7) ;
            drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A147DrogueriaEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaDescripcion", "", "Descripcion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaTipoDocumento", "", "Tipo Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaNroDocumento", "", "Nro Documento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaDireccion", "", "Direccion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "DrogueriaEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "DrogueriaWWColumnsSelector", GXv_char7) ;
      drogueriawwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("DrogueriaWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "DrogueriaWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("DrogueriaWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV72GXV4 = 1 ;
      while ( AV72GXV4 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV72GXV4));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAID") == 0 )
         {
            AV35TFDrogueriaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFDrogueriaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANOMBRE") == 0 )
         {
            AV37TFDrogueriaNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANOMBRE_SEL") == 0 )
         {
            AV38TFDrogueriaNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADESCRIPCION") == 0 )
         {
            AV39TFDrogueriaDescripcion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADESCRIPCION_SEL") == 0 )
         {
            AV40TFDrogueriaDescripcion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIATIPODOCUMENTO_SEL") == 0 )
         {
            AV41TFDrogueriaTipoDocumento_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFDrogueriaTipoDocumento_Sels.fromJSonString(AV41TFDrogueriaTipoDocumento_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANRODOCUMENTO") == 0 )
         {
            AV44TFDrogueriaNroDocumento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIANRODOCUMENTO_SEL") == 0 )
         {
            AV45TFDrogueriaNroDocumento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADIRECCION") == 0 )
         {
            AV46TFDrogueriaDireccion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIADIRECCION_SEL") == 0 )
         {
            AV47TFDrogueriaDireccion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDROGUERIAESTADO_SEL") == 0 )
         {
            AV48TFDrogueriaEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFDrogueriaEstado_Sels.fromJSonString(AV48TFDrogueriaEstado_SelsJson, null);
         }
         AV72GXV4 = (int)(AV72GXV4+1) ;
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
      this.aP0[0] = drogueriawwexport.this.AV12Filename;
      this.aP1[0] = drogueriawwexport.this.AV13ErrorMessage;
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
      AV54Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFDrogueriaNombre_Sel = "" ;
      AV37TFDrogueriaNombre = "" ;
      AV40TFDrogueriaDescripcion_Sel = "" ;
      AV39TFDrogueriaDescripcion = "" ;
      AV42TFDrogueriaTipoDocumento_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFDrogueriaTipoDocumento_Sel = "" ;
      AV45TFDrogueriaNroDocumento_Sel = "" ;
      AV44TFDrogueriaNroDocumento = "" ;
      AV47TFDrogueriaDireccion_Sel = "" ;
      AV46TFDrogueriaDireccion = "" ;
      AV49TFDrogueriaEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV50TFDrogueriaEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A141DrogueriaNombre = "" ;
      A142DrogueriaDescripcion = "" ;
      A143DrogueriaTipoDocumento = "" ;
      A144DrogueriaNroDocumento = "" ;
      A145DrogueriaDireccion = "" ;
      A147DrogueriaEstado = "" ;
      AV59Drogueriawwds_1_filterfulltext = "" ;
      AV62Drogueriawwds_4_tfdroguerianombre = "" ;
      AV63Drogueriawwds_5_tfdroguerianombre_sel = "" ;
      AV64Drogueriawwds_6_tfdrogueriadescripcion = "" ;
      AV65Drogueriawwds_7_tfdrogueriadescripcion_sel = "" ;
      AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67Drogueriawwds_9_tfdroguerianrodocumento = "" ;
      AV68Drogueriawwds_10_tfdroguerianrodocumento_sel = "" ;
      AV69Drogueriawwds_11_tfdrogueriadireccion = "" ;
      AV70Drogueriawwds_12_tfdrogueriadireccion_sel = "" ;
      AV71Drogueriawwds_13_tfdrogueriaestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV59Drogueriawwds_1_filterfulltext = "" ;
      lV62Drogueriawwds_4_tfdroguerianombre = "" ;
      lV64Drogueriawwds_6_tfdrogueriadescripcion = "" ;
      lV67Drogueriawwds_9_tfdroguerianrodocumento = "" ;
      lV69Drogueriawwds_11_tfdrogueriadireccion = "" ;
      P004L2_A36DrogueriaId = new short[1] ;
      P004L2_A147DrogueriaEstado = new String[] {""} ;
      P004L2_A145DrogueriaDireccion = new String[] {""} ;
      P004L2_A144DrogueriaNroDocumento = new String[] {""} ;
      P004L2_A143DrogueriaTipoDocumento = new String[] {""} ;
      P004L2_A142DrogueriaDescripcion = new String[] {""} ;
      P004L2_A141DrogueriaNombre = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFDrogueriaTipoDocumento_SelsJson = "" ;
      AV48TFDrogueriaEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.drogueriawwexport__default(),
         new Object[] {
             new Object[] {
            P004L2_A36DrogueriaId, P004L2_A147DrogueriaEstado, P004L2_A145DrogueriaDireccion, P004L2_A144DrogueriaNroDocumento, P004L2_A143DrogueriaTipoDocumento, P004L2_A142DrogueriaDescripcion, P004L2_A141DrogueriaNombre
            }
         }
      );
      AV54Pgmname = "DrogueriaWWExport" ;
      /* GeneXus formulas. */
      AV54Pgmname = "DrogueriaWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFDrogueriaId ;
   private short AV36TFDrogueriaId_To ;
   private short GXv_int5[] ;
   private short A36DrogueriaId ;
   private short AV60Drogueriawwds_2_tfdrogueriaid ;
   private short AV61Drogueriawwds_3_tfdrogueriaid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV55GXV1 ;
   private int AV56GXV2 ;
   private int AV57GXV3 ;
   private int AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ;
   private int AV71Drogueriawwds_13_tfdrogueriaestado_sels_size ;
   private int AV72GXV4 ;
   private long AV51i ;
   private long AV32VisibleColumnCount ;
   private String AV54Pgmname ;
   private String AV43TFDrogueriaTipoDocumento_Sel ;
   private String AV50TFDrogueriaEstado_Sel ;
   private String A143DrogueriaTipoDocumento ;
   private String A147DrogueriaEstado ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV41TFDrogueriaTipoDocumento_SelsJson ;
   private String AV48TFDrogueriaEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFDrogueriaNombre_Sel ;
   private String AV37TFDrogueriaNombre ;
   private String AV40TFDrogueriaDescripcion_Sel ;
   private String AV39TFDrogueriaDescripcion ;
   private String AV45TFDrogueriaNroDocumento_Sel ;
   private String AV44TFDrogueriaNroDocumento ;
   private String AV47TFDrogueriaDireccion_Sel ;
   private String AV46TFDrogueriaDireccion ;
   private String A141DrogueriaNombre ;
   private String A142DrogueriaDescripcion ;
   private String A144DrogueriaNroDocumento ;
   private String A145DrogueriaDireccion ;
   private String AV59Drogueriawwds_1_filterfulltext ;
   private String AV62Drogueriawwds_4_tfdroguerianombre ;
   private String AV63Drogueriawwds_5_tfdroguerianombre_sel ;
   private String AV64Drogueriawwds_6_tfdrogueriadescripcion ;
   private String AV65Drogueriawwds_7_tfdrogueriadescripcion_sel ;
   private String AV67Drogueriawwds_9_tfdroguerianrodocumento ;
   private String AV68Drogueriawwds_10_tfdroguerianrodocumento_sel ;
   private String AV69Drogueriawwds_11_tfdrogueriadireccion ;
   private String AV70Drogueriawwds_12_tfdrogueriadireccion_sel ;
   private String lV59Drogueriawwds_1_filterfulltext ;
   private String lV62Drogueriawwds_4_tfdroguerianombre ;
   private String lV64Drogueriawwds_6_tfdrogueriadescripcion ;
   private String lV67Drogueriawwds_9_tfdroguerianrodocumento ;
   private String lV69Drogueriawwds_11_tfdrogueriadireccion ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV42TFDrogueriaTipoDocumento_Sels ;
   private GXSimpleCollection<String> AV49TFDrogueriaEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P004L2_A36DrogueriaId ;
   private String[] P004L2_A147DrogueriaEstado ;
   private String[] P004L2_A145DrogueriaDireccion ;
   private String[] P004L2_A144DrogueriaNroDocumento ;
   private String[] P004L2_A143DrogueriaTipoDocumento ;
   private String[] P004L2_A142DrogueriaDescripcion ;
   private String[] P004L2_A141DrogueriaNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels ;
   private GXSimpleCollection<String> AV71Drogueriawwds_13_tfdrogueriaestado_sels ;
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

final  class drogueriawwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004L2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A143DrogueriaTipoDocumento ,
                                          GXSimpleCollection<String> AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels ,
                                          String A147DrogueriaEstado ,
                                          GXSimpleCollection<String> AV71Drogueriawwds_13_tfdrogueriaestado_sels ,
                                          String AV59Drogueriawwds_1_filterfulltext ,
                                          short AV60Drogueriawwds_2_tfdrogueriaid ,
                                          short AV61Drogueriawwds_3_tfdrogueriaid_to ,
                                          String AV63Drogueriawwds_5_tfdroguerianombre_sel ,
                                          String AV62Drogueriawwds_4_tfdroguerianombre ,
                                          String AV65Drogueriawwds_7_tfdrogueriadescripcion_sel ,
                                          String AV64Drogueriawwds_6_tfdrogueriadescripcion ,
                                          int AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels_size ,
                                          String AV68Drogueriawwds_10_tfdroguerianrodocumento_sel ,
                                          String AV67Drogueriawwds_9_tfdroguerianrodocumento ,
                                          String AV70Drogueriawwds_12_tfdrogueriadireccion_sel ,
                                          String AV69Drogueriawwds_11_tfdrogueriadireccion ,
                                          int AV71Drogueriawwds_13_tfdrogueriaestado_sels_size ,
                                          short A36DrogueriaId ,
                                          String A141DrogueriaNombre ,
                                          String A142DrogueriaDescripcion ,
                                          String A144DrogueriaNroDocumento ,
                                          String A145DrogueriaDireccion ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[23];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [DrogueriaId], [DrogueriaEstado], [DrogueriaDireccion], [DrogueriaNroDocumento], [DrogueriaTipoDocumento], [DrogueriaDescripcion], [DrogueriaNombre] FROM" ;
      scmdbuf += " [Drogueria]" ;
      if ( ! (GXutil.strcmp("", AV59Drogueriawwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(4), CAST([DrogueriaId] AS decimal(4,0))) like '%' + ?) or ( [DrogueriaNombre] like '%' + ?) or ( [DrogueriaDescripcion] like '%' + ?) or ( 'dni' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '1') or ( 'ruc' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '6') or ( 'libreta electoral' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '2') or ( 'carnet de extranjeria' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '4') or ( 'pasaporte' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '7') or ( 'sin documento' like '%' + LOWER(?) and [DrogueriaTipoDocumento] = '0') or ( [DrogueriaNroDocumento] like '%' + ?) or ( [DrogueriaDireccion] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [DrogueriaEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [DrogueriaEstado] = 'I'))");
      }
      else
      {
         GXv_int10[0] = (byte)(1) ;
         GXv_int10[1] = (byte)(1) ;
         GXv_int10[2] = (byte)(1) ;
         GXv_int10[3] = (byte)(1) ;
         GXv_int10[4] = (byte)(1) ;
         GXv_int10[5] = (byte)(1) ;
         GXv_int10[6] = (byte)(1) ;
         GXv_int10[7] = (byte)(1) ;
         GXv_int10[8] = (byte)(1) ;
         GXv_int10[9] = (byte)(1) ;
         GXv_int10[10] = (byte)(1) ;
         GXv_int10[11] = (byte)(1) ;
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (0==AV60Drogueriawwds_2_tfdrogueriaid) )
      {
         addWhere(sWhereString, "([DrogueriaId] >= ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( ! (0==AV61Drogueriawwds_3_tfdrogueriaid_to) )
      {
         addWhere(sWhereString, "([DrogueriaId] <= ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV63Drogueriawwds_5_tfdroguerianombre_sel)==0) && ( ! (GXutil.strcmp("", AV62Drogueriawwds_4_tfdroguerianombre)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] like ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Drogueriawwds_5_tfdroguerianombre_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNombre] = ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) && ( ! (GXutil.strcmp("", AV64Drogueriawwds_6_tfdrogueriadescripcion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] like ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Drogueriawwds_7_tfdrogueriadescripcion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDescripcion] = ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV66Drogueriawwds_8_tfdrogueriatipodocumento_sels, "[DrogueriaTipoDocumento] IN (", ")")+")");
      }
      if ( (GXutil.strcmp("", AV68Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV67Drogueriawwds_9_tfdroguerianrodocumento)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] like ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV68Drogueriawwds_10_tfdroguerianrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaNroDocumento] = ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV70Drogueriawwds_12_tfdrogueriadireccion_sel)==0) && ( ! (GXutil.strcmp("", AV69Drogueriawwds_11_tfdrogueriadireccion)==0) ) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] like ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV70Drogueriawwds_12_tfdrogueriadireccion_sel)==0) )
      {
         addWhere(sWhereString, "([DrogueriaDireccion] = ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( AV71Drogueriawwds_13_tfdrogueriaestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV71Drogueriawwds_13_tfdrogueriaestado_sels, "[DrogueriaEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaDescripcion]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaDescripcion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaTipoDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaTipoDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaNroDocumento]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaNroDocumento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaDireccion]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaDireccion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [DrogueriaEstado]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [DrogueriaEstado] DESC" ;
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
                  return conditional_P004L2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Boolean) dynConstraints[23]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004L2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
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
                  stmt.setVarchar(sIdx, (String)parms[23], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 80);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 80);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 15);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 15);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               return;
      }
   }

}


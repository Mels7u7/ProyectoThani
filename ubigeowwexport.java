package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ubigeowwexport extends GXProcedure
{
   public ubigeowwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ubigeowwexport.class ), "" );
   }

   public ubigeowwexport( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      ubigeowwexport.this.aP1 = new String[] {""};
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
      ubigeowwexport.this.aP0 = aP0;
      ubigeowwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean2) ;
      ubigeowwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV57Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "UbigeoWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (GXutil.strcmp("", AV36TFUbigeoCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFUbigeoCode_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV35TFUbigeoCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV35TFUbigeoCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV38TFUbigeoDepartamento_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Departamento") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFUbigeoDepartamento_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFUbigeoDepartamento)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Departamento") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFUbigeoDepartamento, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV40TFUbigeoDepartamentoCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Departamento Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV40TFUbigeoDepartamentoCode_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV39TFUbigeoDepartamentoCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Departamento Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV39TFUbigeoDepartamentoCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV42TFUbigeoProvincia_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Provincia") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV42TFUbigeoProvincia_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV41TFUbigeoProvincia)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Provincia") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV41TFUbigeoProvincia, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV44TFUbigeoProvinciaCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Provincia Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFUbigeoProvinciaCode_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFUbigeoProvinciaCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Provincia Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFUbigeoProvinciaCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFUbigeoDistrito_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Distrito") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFUbigeoDistrito_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFUbigeoDistrito)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Distrito") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFUbigeoDistrito, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV48TFUbigeoDistritoCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Distrito Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFUbigeoDistritoCode_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFUbigeoDistritoCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Distrito Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFUbigeoDistritoCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV50TFUbigeoNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFUbigeoNombre_Sel, GXv_char7) ;
         ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFUbigeoNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFUbigeoNombre, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV52TFUbigeoEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         ubigeowwexport.this.AV14CellRow = GXv_int5[0] ;
         AV54i = 1 ;
         AV58GXV1 = 1 ;
         while ( AV58GXV1 <= AV52TFUbigeoEstado_Sels.size() )
         {
            AV53TFUbigeoEstado_Sel = (String)AV52TFUbigeoEstado_Sels.elementAt(-1+AV58GXV1) ;
            if ( AV54i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV53TFUbigeoEstado_Sel) );
            AV54i = (long)(AV54i+1) ;
            AV58GXV1 = (int)(AV58GXV1+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("UbigeoWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("UbigeoWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV59GXV2 = 1 ;
      while ( AV59GXV2 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV59GXV2));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV59GXV2 = (int)(AV59GXV2+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV61Ubigeowwds_1_filterfulltext = AV19FilterFullText ;
      AV62Ubigeowwds_2_tfubigeocode = AV35TFUbigeoCode ;
      AV63Ubigeowwds_3_tfubigeocode_sel = AV36TFUbigeoCode_Sel ;
      AV64Ubigeowwds_4_tfubigeodepartamento = AV37TFUbigeoDepartamento ;
      AV65Ubigeowwds_5_tfubigeodepartamento_sel = AV38TFUbigeoDepartamento_Sel ;
      AV66Ubigeowwds_6_tfubigeodepartamentocode = AV39TFUbigeoDepartamentoCode ;
      AV67Ubigeowwds_7_tfubigeodepartamentocode_sel = AV40TFUbigeoDepartamentoCode_Sel ;
      AV68Ubigeowwds_8_tfubigeoprovincia = AV41TFUbigeoProvincia ;
      AV69Ubigeowwds_9_tfubigeoprovincia_sel = AV42TFUbigeoProvincia_Sel ;
      AV70Ubigeowwds_10_tfubigeoprovinciacode = AV43TFUbigeoProvinciaCode ;
      AV71Ubigeowwds_11_tfubigeoprovinciacode_sel = AV44TFUbigeoProvinciaCode_Sel ;
      AV72Ubigeowwds_12_tfubigeodistrito = AV45TFUbigeoDistrito ;
      AV73Ubigeowwds_13_tfubigeodistrito_sel = AV46TFUbigeoDistrito_Sel ;
      AV74Ubigeowwds_14_tfubigeodistritocode = AV47TFUbigeoDistritoCode ;
      AV75Ubigeowwds_15_tfubigeodistritocode_sel = AV48TFUbigeoDistritoCode_Sel ;
      AV76Ubigeowwds_16_tfubigeonombre = AV49TFUbigeoNombre ;
      AV77Ubigeowwds_17_tfubigeonombre_sel = AV50TFUbigeoNombre_Sel ;
      AV78Ubigeowwds_18_tfubigeoestado_sels = AV52TFUbigeoEstado_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A294UbigeoEstado ,
                                           AV78Ubigeowwds_18_tfubigeoestado_sels ,
                                           AV61Ubigeowwds_1_filterfulltext ,
                                           AV63Ubigeowwds_3_tfubigeocode_sel ,
                                           AV62Ubigeowwds_2_tfubigeocode ,
                                           AV65Ubigeowwds_5_tfubigeodepartamento_sel ,
                                           AV64Ubigeowwds_4_tfubigeodepartamento ,
                                           AV67Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                           AV66Ubigeowwds_6_tfubigeodepartamentocode ,
                                           AV69Ubigeowwds_9_tfubigeoprovincia_sel ,
                                           AV68Ubigeowwds_8_tfubigeoprovincia ,
                                           AV71Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                           AV70Ubigeowwds_10_tfubigeoprovinciacode ,
                                           AV73Ubigeowwds_13_tfubigeodistrito_sel ,
                                           AV72Ubigeowwds_12_tfubigeodistrito ,
                                           AV75Ubigeowwds_15_tfubigeodistritocode_sel ,
                                           AV74Ubigeowwds_14_tfubigeodistritocode ,
                                           AV77Ubigeowwds_17_tfubigeonombre_sel ,
                                           AV76Ubigeowwds_16_tfubigeonombre ,
                                           Integer.valueOf(AV78Ubigeowwds_18_tfubigeoestado_sels.size()) ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV61Ubigeowwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV61Ubigeowwds_1_filterfulltext), "%", "") ;
      lV62Ubigeowwds_2_tfubigeocode = GXutil.padr( GXutil.rtrim( AV62Ubigeowwds_2_tfubigeocode), 10, "%") ;
      lV64Ubigeowwds_4_tfubigeodepartamento = GXutil.concat( GXutil.rtrim( AV64Ubigeowwds_4_tfubigeodepartamento), "%", "") ;
      lV66Ubigeowwds_6_tfubigeodepartamentocode = GXutil.concat( GXutil.rtrim( AV66Ubigeowwds_6_tfubigeodepartamentocode), "%", "") ;
      lV68Ubigeowwds_8_tfubigeoprovincia = GXutil.concat( GXutil.rtrim( AV68Ubigeowwds_8_tfubigeoprovincia), "%", "") ;
      lV70Ubigeowwds_10_tfubigeoprovinciacode = GXutil.concat( GXutil.rtrim( AV70Ubigeowwds_10_tfubigeoprovinciacode), "%", "") ;
      lV72Ubigeowwds_12_tfubigeodistrito = GXutil.concat( GXutil.rtrim( AV72Ubigeowwds_12_tfubigeodistrito), "%", "") ;
      lV74Ubigeowwds_14_tfubigeodistritocode = GXutil.concat( GXutil.rtrim( AV74Ubigeowwds_14_tfubigeodistritocode), "%", "") ;
      lV76Ubigeowwds_16_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV76Ubigeowwds_16_tfubigeonombre), "%", "") ;
      /* Using cursor P00552 */
      pr_default.execute(0, new Object[] {lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV61Ubigeowwds_1_filterfulltext, lV62Ubigeowwds_2_tfubigeocode, AV63Ubigeowwds_3_tfubigeocode_sel, lV64Ubigeowwds_4_tfubigeodepartamento, AV65Ubigeowwds_5_tfubigeodepartamento_sel, lV66Ubigeowwds_6_tfubigeodepartamentocode, AV67Ubigeowwds_7_tfubigeodepartamentocode_sel, lV68Ubigeowwds_8_tfubigeoprovincia, AV69Ubigeowwds_9_tfubigeoprovincia_sel, lV70Ubigeowwds_10_tfubigeoprovinciacode, AV71Ubigeowwds_11_tfubigeoprovinciacode_sel, lV72Ubigeowwds_12_tfubigeodistrito, AV73Ubigeowwds_13_tfubigeodistrito_sel, lV74Ubigeowwds_14_tfubigeodistritocode, AV75Ubigeowwds_15_tfubigeodistritocode_sel, lV76Ubigeowwds_16_tfubigeonombre, AV77Ubigeowwds_17_tfubigeonombre_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A294UbigeoEstado = P00552_A294UbigeoEstado[0] ;
         A44UbigeoCode = P00552_A44UbigeoCode[0] ;
         A188UbigeoDistrito = P00552_A188UbigeoDistrito[0] ;
         A187UbigeoProvincia = P00552_A187UbigeoProvincia[0] ;
         A186UbigeoDepartamento = P00552_A186UbigeoDepartamento[0] ;
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
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
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A44UbigeoCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A186UbigeoDepartamento, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A295UbigeoDepartamentoCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A187UbigeoProvincia, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A296UbigeoProvinciaCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A188UbigeoDistrito, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A297UbigeoDistritoCode, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A185UbigeoNombre, GXv_char7) ;
            ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A294UbigeoEstado) );
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoCode", "", "Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoDepartamento", "", "Departamento", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoDepartamentoCode", "", "Departamento Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoProvincia", "", "Provincia", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoProvinciaCode", "", "Provincia Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoDistrito", "", "Distrito", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoDistritoCode", "", "Distrito Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "UbigeoWWColumnsSelector", GXv_char7) ;
      ubigeowwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("UbigeoWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "UbigeoWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("UbigeoWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV79GXV3 = 1 ;
      while ( AV79GXV3 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV79GXV3));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV35TFUbigeoCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV36TFUbigeoCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO") == 0 )
         {
            AV37TFUbigeoDepartamento = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTO_SEL") == 0 )
         {
            AV38TFUbigeoDepartamento_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE") == 0 )
         {
            AV39TFUbigeoDepartamentoCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODEPARTAMENTOCODE_SEL") == 0 )
         {
            AV40TFUbigeoDepartamentoCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA") == 0 )
         {
            AV41TFUbigeoProvincia = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIA_SEL") == 0 )
         {
            AV42TFUbigeoProvincia_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE") == 0 )
         {
            AV43TFUbigeoProvinciaCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOPROVINCIACODE_SEL") == 0 )
         {
            AV44TFUbigeoProvinciaCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO") == 0 )
         {
            AV45TFUbigeoDistrito = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITO_SEL") == 0 )
         {
            AV46TFUbigeoDistrito_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE") == 0 )
         {
            AV47TFUbigeoDistritoCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEODISTRITOCODE_SEL") == 0 )
         {
            AV48TFUbigeoDistritoCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV49TFUbigeoNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV50TFUbigeoNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOESTADO_SEL") == 0 )
         {
            AV51TFUbigeoEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV52TFUbigeoEstado_Sels.fromJSonString(AV51TFUbigeoEstado_SelsJson, null);
         }
         AV79GXV3 = (int)(AV79GXV3+1) ;
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
      this.aP0[0] = ubigeowwexport.this.AV12Filename;
      this.aP1[0] = ubigeowwexport.this.AV13ErrorMessage;
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
      AV57Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV36TFUbigeoCode_Sel = "" ;
      AV35TFUbigeoCode = "" ;
      AV38TFUbigeoDepartamento_Sel = "" ;
      AV37TFUbigeoDepartamento = "" ;
      AV40TFUbigeoDepartamentoCode_Sel = "" ;
      AV39TFUbigeoDepartamentoCode = "" ;
      AV42TFUbigeoProvincia_Sel = "" ;
      AV41TFUbigeoProvincia = "" ;
      AV44TFUbigeoProvinciaCode_Sel = "" ;
      AV43TFUbigeoProvinciaCode = "" ;
      AV46TFUbigeoDistrito_Sel = "" ;
      AV45TFUbigeoDistrito = "" ;
      AV48TFUbigeoDistritoCode_Sel = "" ;
      AV47TFUbigeoDistritoCode = "" ;
      AV50TFUbigeoNombre_Sel = "" ;
      AV49TFUbigeoNombre = "" ;
      AV52TFUbigeoEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV53TFUbigeoEstado_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A44UbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A187UbigeoProvincia = "" ;
      A296UbigeoProvinciaCode = "" ;
      A188UbigeoDistrito = "" ;
      A297UbigeoDistritoCode = "" ;
      A185UbigeoNombre = "" ;
      A294UbigeoEstado = "" ;
      AV61Ubigeowwds_1_filterfulltext = "" ;
      AV62Ubigeowwds_2_tfubigeocode = "" ;
      AV63Ubigeowwds_3_tfubigeocode_sel = "" ;
      AV64Ubigeowwds_4_tfubigeodepartamento = "" ;
      AV65Ubigeowwds_5_tfubigeodepartamento_sel = "" ;
      AV66Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      AV67Ubigeowwds_7_tfubigeodepartamentocode_sel = "" ;
      AV68Ubigeowwds_8_tfubigeoprovincia = "" ;
      AV69Ubigeowwds_9_tfubigeoprovincia_sel = "" ;
      AV70Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      AV71Ubigeowwds_11_tfubigeoprovinciacode_sel = "" ;
      AV72Ubigeowwds_12_tfubigeodistrito = "" ;
      AV73Ubigeowwds_13_tfubigeodistrito_sel = "" ;
      AV74Ubigeowwds_14_tfubigeodistritocode = "" ;
      AV75Ubigeowwds_15_tfubigeodistritocode_sel = "" ;
      AV76Ubigeowwds_16_tfubigeonombre = "" ;
      AV77Ubigeowwds_17_tfubigeonombre_sel = "" ;
      AV78Ubigeowwds_18_tfubigeoestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV61Ubigeowwds_1_filterfulltext = "" ;
      lV62Ubigeowwds_2_tfubigeocode = "" ;
      lV64Ubigeowwds_4_tfubigeodepartamento = "" ;
      lV66Ubigeowwds_6_tfubigeodepartamentocode = "" ;
      lV68Ubigeowwds_8_tfubigeoprovincia = "" ;
      lV70Ubigeowwds_10_tfubigeoprovinciacode = "" ;
      lV72Ubigeowwds_12_tfubigeodistrito = "" ;
      lV74Ubigeowwds_14_tfubigeodistritocode = "" ;
      lV76Ubigeowwds_16_tfubigeonombre = "" ;
      P00552_A294UbigeoEstado = new String[] {""} ;
      P00552_A44UbigeoCode = new String[] {""} ;
      P00552_A188UbigeoDistrito = new String[] {""} ;
      P00552_A187UbigeoProvincia = new String[] {""} ;
      P00552_A186UbigeoDepartamento = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV51TFUbigeoEstado_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ubigeowwexport__default(),
         new Object[] {
             new Object[] {
            P00552_A294UbigeoEstado, P00552_A44UbigeoCode, P00552_A188UbigeoDistrito, P00552_A187UbigeoProvincia, P00552_A186UbigeoDepartamento
            }
         }
      );
      AV57Pgmname = "UbigeoWWExport" ;
      /* GeneXus formulas. */
      AV57Pgmname = "UbigeoWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short GXv_int5[] ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV58GXV1 ;
   private int AV59GXV2 ;
   private int AV78Ubigeowwds_18_tfubigeoestado_sels_size ;
   private int AV79GXV3 ;
   private long AV54i ;
   private long AV32VisibleColumnCount ;
   private String AV57Pgmname ;
   private String AV36TFUbigeoCode_Sel ;
   private String AV35TFUbigeoCode ;
   private String AV53TFUbigeoEstado_Sel ;
   private String A44UbigeoCode ;
   private String A294UbigeoEstado ;
   private String AV62Ubigeowwds_2_tfubigeocode ;
   private String AV63Ubigeowwds_3_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV62Ubigeowwds_2_tfubigeocode ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV51TFUbigeoEstado_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFUbigeoDepartamento_Sel ;
   private String AV37TFUbigeoDepartamento ;
   private String AV40TFUbigeoDepartamentoCode_Sel ;
   private String AV39TFUbigeoDepartamentoCode ;
   private String AV42TFUbigeoProvincia_Sel ;
   private String AV41TFUbigeoProvincia ;
   private String AV44TFUbigeoProvinciaCode_Sel ;
   private String AV43TFUbigeoProvinciaCode ;
   private String AV46TFUbigeoDistrito_Sel ;
   private String AV45TFUbigeoDistrito ;
   private String AV48TFUbigeoDistritoCode_Sel ;
   private String AV47TFUbigeoDistritoCode ;
   private String AV50TFUbigeoNombre_Sel ;
   private String AV49TFUbigeoNombre ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String A187UbigeoProvincia ;
   private String A296UbigeoProvinciaCode ;
   private String A188UbigeoDistrito ;
   private String A297UbigeoDistritoCode ;
   private String A185UbigeoNombre ;
   private String AV61Ubigeowwds_1_filterfulltext ;
   private String AV64Ubigeowwds_4_tfubigeodepartamento ;
   private String AV65Ubigeowwds_5_tfubigeodepartamento_sel ;
   private String AV66Ubigeowwds_6_tfubigeodepartamentocode ;
   private String AV67Ubigeowwds_7_tfubigeodepartamentocode_sel ;
   private String AV68Ubigeowwds_8_tfubigeoprovincia ;
   private String AV69Ubigeowwds_9_tfubigeoprovincia_sel ;
   private String AV70Ubigeowwds_10_tfubigeoprovinciacode ;
   private String AV71Ubigeowwds_11_tfubigeoprovinciacode_sel ;
   private String AV72Ubigeowwds_12_tfubigeodistrito ;
   private String AV73Ubigeowwds_13_tfubigeodistrito_sel ;
   private String AV74Ubigeowwds_14_tfubigeodistritocode ;
   private String AV75Ubigeowwds_15_tfubigeodistritocode_sel ;
   private String AV76Ubigeowwds_16_tfubigeonombre ;
   private String AV77Ubigeowwds_17_tfubigeonombre_sel ;
   private String lV61Ubigeowwds_1_filterfulltext ;
   private String lV64Ubigeowwds_4_tfubigeodepartamento ;
   private String lV66Ubigeowwds_6_tfubigeodepartamentocode ;
   private String lV68Ubigeowwds_8_tfubigeoprovincia ;
   private String lV70Ubigeowwds_10_tfubigeoprovinciacode ;
   private String lV72Ubigeowwds_12_tfubigeodistrito ;
   private String lV74Ubigeowwds_14_tfubigeodistritocode ;
   private String lV76Ubigeowwds_16_tfubigeonombre ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV52TFUbigeoEstado_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00552_A294UbigeoEstado ;
   private String[] P00552_A44UbigeoCode ;
   private String[] P00552_A188UbigeoDistrito ;
   private String[] P00552_A187UbigeoProvincia ;
   private String[] P00552_A186UbigeoDepartamento ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV78Ubigeowwds_18_tfubigeoestado_sels ;
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

final  class ubigeowwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00552( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A294UbigeoEstado ,
                                          GXSimpleCollection<String> AV78Ubigeowwds_18_tfubigeoestado_sels ,
                                          String AV61Ubigeowwds_1_filterfulltext ,
                                          String AV63Ubigeowwds_3_tfubigeocode_sel ,
                                          String AV62Ubigeowwds_2_tfubigeocode ,
                                          String AV65Ubigeowwds_5_tfubigeodepartamento_sel ,
                                          String AV64Ubigeowwds_4_tfubigeodepartamento ,
                                          String AV67Ubigeowwds_7_tfubigeodepartamentocode_sel ,
                                          String AV66Ubigeowwds_6_tfubigeodepartamentocode ,
                                          String AV69Ubigeowwds_9_tfubigeoprovincia_sel ,
                                          String AV68Ubigeowwds_8_tfubigeoprovincia ,
                                          String AV71Ubigeowwds_11_tfubigeoprovinciacode_sel ,
                                          String AV70Ubigeowwds_10_tfubigeoprovinciacode ,
                                          String AV73Ubigeowwds_13_tfubigeodistrito_sel ,
                                          String AV72Ubigeowwds_12_tfubigeodistrito ,
                                          String AV75Ubigeowwds_15_tfubigeodistritocode_sel ,
                                          String AV74Ubigeowwds_14_tfubigeodistritocode ,
                                          String AV77Ubigeowwds_17_tfubigeonombre_sel ,
                                          String AV76Ubigeowwds_16_tfubigeonombre ,
                                          int AV78Ubigeowwds_18_tfubigeoestado_sels_size ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[26];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT [UbigeoEstado], [UbigeoCode], [UbigeoDistrito], [UbigeoProvincia], [UbigeoDepartamento] FROM [Ubigeo]" ;
      if ( ! (GXutil.strcmp("", AV61Ubigeowwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( [UbigeoCode] like '%' + ?) or ( [UbigeoDepartamento] like '%' + ?) or ( SUBSTRING([UbigeoCode], 1, 2) like '%' + ?) or ( [UbigeoProvincia] like '%' + ?) or ( SUBSTRING([UbigeoCode], 3, 2) like '%' + ?) or ( [UbigeoDistrito] like '%' + ?) or ( SUBSTRING([UbigeoCode], 5, 2) like '%' + ?) or ( [UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and [UbigeoEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and [UbigeoEstado] = 'I'))");
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
      }
      if ( (GXutil.strcmp("", AV63Ubigeowwds_3_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV62Ubigeowwds_2_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoCode] like ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63Ubigeowwds_3_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoCode] = ?)");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV65Ubigeowwds_5_tfubigeodepartamento_sel)==0) && ( ! (GXutil.strcmp("", AV64Ubigeowwds_4_tfubigeodepartamento)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] like ?)");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV65Ubigeowwds_5_tfubigeodepartamento_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] = ?)");
      }
      else
      {
         GXv_int10[13] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV67Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) && ( ! (GXutil.strcmp("", AV66Ubigeowwds_6_tfubigeodepartamentocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) like ?)");
      }
      else
      {
         GXv_int10[14] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV67Ubigeowwds_7_tfubigeodepartamentocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 1, 2) = ?)");
      }
      else
      {
         GXv_int10[15] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV69Ubigeowwds_9_tfubigeoprovincia_sel)==0) && ( ! (GXutil.strcmp("", AV68Ubigeowwds_8_tfubigeoprovincia)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] like ?)");
      }
      else
      {
         GXv_int10[16] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV69Ubigeowwds_9_tfubigeoprovincia_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoProvincia] = ?)");
      }
      else
      {
         GXv_int10[17] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV71Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) && ( ! (GXutil.strcmp("", AV70Ubigeowwds_10_tfubigeoprovinciacode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) like ?)");
      }
      else
      {
         GXv_int10[18] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV71Ubigeowwds_11_tfubigeoprovinciacode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 3, 2) = ?)");
      }
      else
      {
         GXv_int10[19] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV73Ubigeowwds_13_tfubigeodistrito_sel)==0) && ( ! (GXutil.strcmp("", AV72Ubigeowwds_12_tfubigeodistrito)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV73Ubigeowwds_13_tfubigeodistrito_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Ubigeowwds_15_tfubigeodistritocode_sel)==0) && ( ! (GXutil.strcmp("", AV74Ubigeowwds_14_tfubigeodistritocode)==0) ) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) like ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Ubigeowwds_15_tfubigeodistritocode_sel)==0) )
      {
         addWhere(sWhereString, "(SUBSTRING([UbigeoCode], 5, 2) = ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV77Ubigeowwds_17_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV76Ubigeowwds_16_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV77Ubigeowwds_17_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "([UbigeoDepartamento] + ' / ' + [UbigeoProvincia] + ' / ' + [UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( AV78Ubigeowwds_18_tfubigeoestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV78Ubigeowwds_18_tfubigeoestado_sels, "[UbigeoEstado] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoCode]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoDepartamento]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoDepartamento] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoProvincia]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoProvincia] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoDistrito]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoDistrito] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY [UbigeoEstado]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY [UbigeoEstado] DESC" ;
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
                  return conditional_P00552(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).shortValue() , ((Boolean) dynConstraints[25]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00552", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
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
                  stmt.setVarchar(sIdx, (String)parms[26], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[27], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[28], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[29], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[32], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[33], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[34], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[35], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[36], 10);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[37], 10);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 2);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 2);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 2);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               return;
      }
   }

}


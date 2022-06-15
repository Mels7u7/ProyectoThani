package com.projectthani ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sedewwexport extends GXProcedure
{
   public sedewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sedewwexport.class ), "" );
   }

   public sedewwexport( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      sedewwexport.this.aP1 = new String[] {""};
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
      sedewwexport.this.aP0 = aP0;
      sedewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede", GXv_boolean2) ;
      sedewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV65Pgmname))}, new String[] {"GxObject"}) );
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
      AV12Filename = "SedeWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
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
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      if ( ! ( (0==AV35TFSedeId) && (0==AV36TFSedeId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV35TFSedeId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV36TFSedeId_To );
      }
      if ( ! ( (GXutil.strcmp("", AV38TFSedeNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSedeNombre_Sel, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFSedeNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sedewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFSedeNombre, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (0==AV39TFClinicaId) && (0==AV40TFClinicaId_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Clinica Id") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV39TFClinicaId );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV40TFClinicaId_To );
      }
      if ( ! ( (0==AV41TFClinicaRUC) && (0==AV42TFClinicaRUC_To) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Clinica RUC") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setNumber( AV41TFClinicaRUC );
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, false, GXv_int5, (short)(AV15FirstColumn+2), "Hasta") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setNumber( AV42TFClinicaRUC_To );
      }
      if ( ! ( (GXutil.strcmp("", AV44TFClinicaNombreComercial_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Comercial") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV44TFClinicaNombreComercial_Sel, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV43TFClinicaNombreComercial)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Nombre Comercial") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sedewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV43TFClinicaNombreComercial, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV46TFUbigeoCode_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo Code") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV46TFUbigeoCode_Sel, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV45TFUbigeoCode)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo Code") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sedewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV45TFUbigeoCode, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV48TFUbigeoNombre_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV48TFUbigeoNombre_Sel, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV47TFUbigeoNombre)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Ubigeo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sedewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV47TFUbigeoNombre, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV50TFSedeDireccion_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV50TFSedeDireccion_Sel, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV49TFSedeDireccion)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Direccion") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sedewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV49TFSedeDireccion, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( (GXutil.strcmp("", AV52TFSedeCorreo_Sel)==0) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Correo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         GXt_char6 = "" ;
         GXv_char7[0] = GXt_char6 ;
         new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV52TFSedeCorreo_Sel, GXv_char7) ;
         sedewwexport.this.GXt_char6 = GXv_char7[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV51TFSedeCorreo)==0) ) )
         {
            GXv_exceldoc4[0] = AV11ExcelDocument ;
            GXv_int5[0] = (short)(AV14CellRow) ;
            new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Correo") ;
            AV11ExcelDocument = GXv_exceldoc4[0] ;
            sedewwexport.this.AV14CellRow = GXv_int5[0] ;
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV51TFSedeCorreo, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char6 );
         }
      }
      if ( ! ( ( AV54TFSedeEstado_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Estado") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV66GXV1 = 1 ;
         while ( AV66GXV1 <= AV54TFSedeEstado_Sels.size() )
         {
            AV55TFSedeEstado_Sel = (String)AV54TFSedeEstado_Sels.elementAt(-1+AV66GXV1) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomainestado.getDescription(httpContext,(String)AV55TFSedeEstado_Sel) );
            AV62i = (long)(AV62i+1) ;
            AV66GXV1 = (int)(AV66GXV1+1) ;
         }
      }
      if ( ! ( ( AV57TFSedeTipo_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Tipo") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV67GXV2 = 1 ;
         while ( AV67GXV2 <= AV57TFSedeTipo_Sels.size() )
         {
            AV58TFSedeTipo_Sel = (String)AV57TFSedeTipo_Sels.elementAt(-1+AV67GXV2) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintiposede.getDescription(httpContext,(String)AV58TFSedeTipo_Sel) );
            AV62i = (long)(AV62i+1) ;
            AV67GXV2 = (int)(AV67GXV2+1) ;
         }
      }
      if ( ! ( ( AV60TFSedeSector_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc4[0] = AV11ExcelDocument ;
         GXv_int5[0] = (short)(AV14CellRow) ;
         new com.projectthani.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc4, true, GXv_int5, (short)(AV15FirstColumn), "Sector") ;
         AV11ExcelDocument = GXv_exceldoc4[0] ;
         sedewwexport.this.AV14CellRow = GXv_int5[0] ;
         AV62i = 1 ;
         AV68GXV3 = 1 ;
         while ( AV68GXV3 <= AV60TFSedeSector_Sels.size() )
         {
            AV61TFSedeSector_Sel = (String)AV60TFSedeSector_Sels.elementAt(-1+AV68GXV3) ;
            if ( AV62i == 1 )
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+", " );
            }
            AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).getText()+com.projectthani.gxdomaintiposector.getDescription(httpContext,(String)AV61TFSedeSector_Sel) );
            AV62i = (long)(AV62i+1) ;
            AV68GXV3 = (int)(AV68GXV3+1) ;
         }
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV32VisibleColumnCount = 0 ;
      if ( GXutil.strcmp(AV20Session.getValue("SedeWWColumnsSelector"), "") != 0 )
      {
         AV27ColumnsSelectorXML = AV20Session.getValue("SedeWWColumnsSelector") ;
         AV24ColumnsSelector.fromxml(AV27ColumnsSelectorXML, null, null);
      }
      else
      {
         /* Execute user subroutine: 'INITIALIZECOLUMNSSELECTOR' */
         S151 ();
         if (returnInSub) return;
      }
      AV69GXV4 = 1 ;
      while ( AV69GXV4 <= AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().size() )
      {
         AV26ColumnsSelector_Column = (com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+AV69GXV4));
         if ( AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( httpContext.getMessage( ((GXutil.strcmp("", AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname())==0) ? AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Columnname() : AV26ColumnsSelector_Column.getgxTv_SdtWWPColumnsSelector_Column_Displayname()), "") );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setBold( (short)(1) );
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setColor( 11 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         AV69GXV4 = (int)(AV69GXV4+1) ;
      }
   }

   public void S161( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV71Sedewwds_1_filterfulltext = AV19FilterFullText ;
      AV72Sedewwds_2_tfsedeid = AV35TFSedeId ;
      AV73Sedewwds_3_tfsedeid_to = AV36TFSedeId_To ;
      AV74Sedewwds_4_tfsedenombre = AV37TFSedeNombre ;
      AV75Sedewwds_5_tfsedenombre_sel = AV38TFSedeNombre_Sel ;
      AV76Sedewwds_6_tfclinicaid = AV39TFClinicaId ;
      AV77Sedewwds_7_tfclinicaid_to = AV40TFClinicaId_To ;
      AV78Sedewwds_8_tfclinicaruc = AV41TFClinicaRUC ;
      AV79Sedewwds_9_tfclinicaruc_to = AV42TFClinicaRUC_To ;
      AV80Sedewwds_10_tfclinicanombrecomercial = AV43TFClinicaNombreComercial ;
      AV81Sedewwds_11_tfclinicanombrecomercial_sel = AV44TFClinicaNombreComercial_Sel ;
      AV82Sedewwds_12_tfubigeocode = AV45TFUbigeoCode ;
      AV83Sedewwds_13_tfubigeocode_sel = AV46TFUbigeoCode_Sel ;
      AV84Sedewwds_14_tfubigeonombre = AV47TFUbigeoNombre ;
      AV85Sedewwds_15_tfubigeonombre_sel = AV48TFUbigeoNombre_Sel ;
      AV86Sedewwds_16_tfsededireccion = AV49TFSedeDireccion ;
      AV87Sedewwds_17_tfsededireccion_sel = AV50TFSedeDireccion_Sel ;
      AV88Sedewwds_18_tfsedecorreo = AV51TFSedeCorreo ;
      AV89Sedewwds_19_tfsedecorreo_sel = AV52TFSedeCorreo_Sel ;
      AV90Sedewwds_20_tfsedeestado_sels = AV54TFSedeEstado_Sels ;
      AV91Sedewwds_21_tfsedetipo_sels = AV57TFSedeTipo_Sels ;
      AV92Sedewwds_22_tfsedesector_sels = AV60TFSedeSector_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A278SedeEstado ,
                                           AV90Sedewwds_20_tfsedeestado_sels ,
                                           A279SedeTipo ,
                                           AV91Sedewwds_21_tfsedetipo_sels ,
                                           A280SedeSector ,
                                           AV92Sedewwds_22_tfsedesector_sels ,
                                           Short.valueOf(AV72Sedewwds_2_tfsedeid) ,
                                           Short.valueOf(AV73Sedewwds_3_tfsedeid_to) ,
                                           AV75Sedewwds_5_tfsedenombre_sel ,
                                           AV74Sedewwds_4_tfsedenombre ,
                                           Short.valueOf(AV76Sedewwds_6_tfclinicaid) ,
                                           Short.valueOf(AV77Sedewwds_7_tfclinicaid_to) ,
                                           Long.valueOf(AV78Sedewwds_8_tfclinicaruc) ,
                                           Long.valueOf(AV79Sedewwds_9_tfclinicaruc_to) ,
                                           AV81Sedewwds_11_tfclinicanombrecomercial_sel ,
                                           AV80Sedewwds_10_tfclinicanombrecomercial ,
                                           AV83Sedewwds_13_tfubigeocode_sel ,
                                           AV82Sedewwds_12_tfubigeocode ,
                                           AV85Sedewwds_15_tfubigeonombre_sel ,
                                           AV84Sedewwds_14_tfubigeonombre ,
                                           AV87Sedewwds_17_tfsededireccion_sel ,
                                           AV86Sedewwds_16_tfsededireccion ,
                                           AV89Sedewwds_19_tfsedecorreo_sel ,
                                           AV88Sedewwds_18_tfsedecorreo ,
                                           Integer.valueOf(AV90Sedewwds_20_tfsedeestado_sels.size()) ,
                                           Integer.valueOf(AV91Sedewwds_21_tfsedetipo_sels.size()) ,
                                           Integer.valueOf(AV92Sedewwds_22_tfsedesector_sels.size()) ,
                                           Short.valueOf(A30SedeId) ,
                                           A75SedeNombre ,
                                           Short.valueOf(A28ClinicaId) ,
                                           Long.valueOf(A118ClinicaRUC) ,
                                           A116ClinicaNombreComercial ,
                                           A44UbigeoCode ,
                                           A186UbigeoDepartamento ,
                                           A187UbigeoProvincia ,
                                           A188UbigeoDistrito ,
                                           A276SedeDireccion ,
                                           A277SedeCorreo ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) ,
                                           AV71Sedewwds_1_filterfulltext ,
                                           A185UbigeoNombre } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.LONG,
                                           TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV71Sedewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV71Sedewwds_1_filterfulltext), "%", "") ;
      lV74Sedewwds_4_tfsedenombre = GXutil.concat( GXutil.rtrim( AV74Sedewwds_4_tfsedenombre), "%", "") ;
      lV80Sedewwds_10_tfclinicanombrecomercial = GXutil.concat( GXutil.rtrim( AV80Sedewwds_10_tfclinicanombrecomercial), "%", "") ;
      lV82Sedewwds_12_tfubigeocode = GXutil.padr( GXutil.rtrim( AV82Sedewwds_12_tfubigeocode), 10, "%") ;
      lV84Sedewwds_14_tfubigeonombre = GXutil.concat( GXutil.rtrim( AV84Sedewwds_14_tfubigeonombre), "%", "") ;
      lV86Sedewwds_16_tfsededireccion = GXutil.concat( GXutil.rtrim( AV86Sedewwds_16_tfsededireccion), "%", "") ;
      lV88Sedewwds_18_tfsedecorreo = GXutil.concat( GXutil.rtrim( AV88Sedewwds_18_tfsedecorreo), "%", "") ;
      /* Using cursor P004B2 */
      pr_default.execute(0, new Object[] {AV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, lV71Sedewwds_1_filterfulltext, Short.valueOf(AV72Sedewwds_2_tfsedeid), Short.valueOf(AV73Sedewwds_3_tfsedeid_to), lV74Sedewwds_4_tfsedenombre, AV75Sedewwds_5_tfsedenombre_sel, Short.valueOf(AV76Sedewwds_6_tfclinicaid), Short.valueOf(AV77Sedewwds_7_tfclinicaid_to), Long.valueOf(AV78Sedewwds_8_tfclinicaruc), Long.valueOf(AV79Sedewwds_9_tfclinicaruc_to), lV80Sedewwds_10_tfclinicanombrecomercial, AV81Sedewwds_11_tfclinicanombrecomercial_sel, lV82Sedewwds_12_tfubigeocode, AV83Sedewwds_13_tfubigeocode_sel, lV84Sedewwds_14_tfubigeonombre, AV85Sedewwds_15_tfubigeonombre_sel, lV86Sedewwds_16_tfsededireccion, AV87Sedewwds_17_tfsededireccion_sel, lV88Sedewwds_18_tfsedecorreo, AV89Sedewwds_19_tfsedecorreo_sel});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A118ClinicaRUC = P004B2_A118ClinicaRUC[0] ;
         A28ClinicaId = P004B2_A28ClinicaId[0] ;
         A30SedeId = P004B2_A30SedeId[0] ;
         A280SedeSector = P004B2_A280SedeSector[0] ;
         A279SedeTipo = P004B2_A279SedeTipo[0] ;
         A278SedeEstado = P004B2_A278SedeEstado[0] ;
         A277SedeCorreo = P004B2_A277SedeCorreo[0] ;
         A276SedeDireccion = P004B2_A276SedeDireccion[0] ;
         A185UbigeoNombre = P004B2_A185UbigeoNombre[0] ;
         A44UbigeoCode = P004B2_A44UbigeoCode[0] ;
         A116ClinicaNombreComercial = P004B2_A116ClinicaNombreComercial[0] ;
         A75SedeNombre = P004B2_A75SedeNombre[0] ;
         A186UbigeoDepartamento = P004B2_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P004B2_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P004B2_A188UbigeoDistrito[0] ;
         A118ClinicaRUC = P004B2_A118ClinicaRUC[0] ;
         A116ClinicaNombreComercial = P004B2_A116ClinicaNombreComercial[0] ;
         A185UbigeoNombre = P004B2_A185UbigeoNombre[0] ;
         A186UbigeoDepartamento = P004B2_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = P004B2_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = P004B2_A188UbigeoDistrito[0] ;
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
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A30SedeId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+2)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A75SedeNombre, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+3)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A28ClinicaId );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+4)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setNumber( A118ClinicaRUC );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+5)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A116ClinicaNombreComercial, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+6)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A44UbigeoCode, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+7)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A185UbigeoNombre, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+8)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A276SedeDireccion, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+9)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            GXt_char6 = "" ;
            GXv_char7[0] = GXt_char6 ;
            new com.projectthani.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A277SedeCorreo, GXv_char7) ;
            sedewwexport.this.GXt_char6 = GXv_char7[0] ;
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( GXt_char6 );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+10)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomainestado.getDescription(httpContext,(String)A278SedeEstado) );
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+11)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            if ( ! (GXutil.strcmp("", A279SedeTipo)==0) )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintiposede.getDescription(httpContext,(String)A279SedeTipo) );
            }
            AV32VisibleColumnCount = (long)(AV32VisibleColumnCount+1) ;
         }
         if ( ((com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column)AV24ColumnsSelector.getgxTv_SdtWWPColumnsSelector_Columns().elementAt(-1+12)).getgxTv_SdtWWPColumnsSelector_Column_Isvisible() )
         {
            if ( ! (GXutil.strcmp("", A280SedeSector)==0) )
            {
               AV11ExcelDocument.Cells(AV14CellRow, (int)(AV15FirstColumn+AV32VisibleColumnCount), 1, 1).setText( com.projectthani.gxdomaintiposector.getDescription(httpContext,(String)A280SedeSector) );
            }
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
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeId", "", "Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeNombre", "", "Nombre", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaId", "", "Clinica Id", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaRUC", "", "Clinica RUC", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "ClinicaNombreComercial", "", "Nombre Comercial", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoCode", "", "Ubigeo Code", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "UbigeoNombre", "", "Ubigeo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeDireccion", "", "Direccion", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeCorreo", "", "Correo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeEstado", "", "Estado", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeTipo", "", "Tipo", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXv_SdtWWPColumnsSelector8[0] = AV24ColumnsSelector;
      new com.projectthani.wwpbaseobjects.wwp_columnsselector_add(remoteHandle, context).execute( GXv_SdtWWPColumnsSelector8, "SedeSector", "", "Sector", true, "") ;
      AV24ColumnsSelector = GXv_SdtWWPColumnsSelector8[0] ;
      GXt_char6 = AV28UserCustomValue ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.loadcolumnsselectorstate(remoteHandle, context).execute( "SedeWWColumnsSelector", GXv_char7) ;
      sedewwexport.this.GXt_char6 = GXv_char7[0] ;
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
      if ( GXutil.strcmp(AV20Session.getValue("SedeWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SedeWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("SedeWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV93GXV5 = 1 ;
      while ( AV93GXV5 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV93GXV5));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEID") == 0 )
         {
            AV35TFSedeId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV36TFSedeId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE") == 0 )
         {
            AV37TFSedeNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDENOMBRE_SEL") == 0 )
         {
            AV38TFSedeNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICAID") == 0 )
         {
            AV39TFClinicaId = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV40TFClinicaId_To = (short)(GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICARUC") == 0 )
         {
            AV41TFClinicaRUC = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV42TFClinicaRUC_To = GXutil.lval( AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL") == 0 )
         {
            AV43TFClinicaNombreComercial = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLINICANOMBRECOMERCIAL_SEL") == 0 )
         {
            AV44TFClinicaNombreComercial_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE") == 0 )
         {
            AV45TFUbigeoCode = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEOCODE_SEL") == 0 )
         {
            AV46TFUbigeoCode_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE") == 0 )
         {
            AV47TFUbigeoNombre = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFUBIGEONOMBRE_SEL") == 0 )
         {
            AV48TFUbigeoNombre_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION") == 0 )
         {
            AV49TFSedeDireccion = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEDIRECCION_SEL") == 0 )
         {
            AV50TFSedeDireccion_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO") == 0 )
         {
            AV51TFSedeCorreo = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDECORREO_SEL") == 0 )
         {
            AV52TFSedeCorreo_Sel = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDEESTADO_SEL") == 0 )
         {
            AV53TFSedeEstado_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV54TFSedeEstado_Sels.fromJSonString(AV53TFSedeEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDETIPO_SEL") == 0 )
         {
            AV56TFSedeTipo_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV57TFSedeTipo_Sels.fromJSonString(AV56TFSedeTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSEDESECTOR_SEL") == 0 )
         {
            AV59TFSedeSector_SelsJson = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV60TFSedeSector_Sels.fromJSonString(AV59TFSedeSector_SelsJson, null);
         }
         AV93GXV5 = (int)(AV93GXV5+1) ;
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
      this.aP0[0] = sedewwexport.this.AV12Filename;
      this.aP1[0] = sedewwexport.this.AV13ErrorMessage;
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
      AV65Pgmname = "" ;
      AV9WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      AV38TFSedeNombre_Sel = "" ;
      AV37TFSedeNombre = "" ;
      AV44TFClinicaNombreComercial_Sel = "" ;
      AV43TFClinicaNombreComercial = "" ;
      AV46TFUbigeoCode_Sel = "" ;
      AV45TFUbigeoCode = "" ;
      AV48TFUbigeoNombre_Sel = "" ;
      AV47TFUbigeoNombre = "" ;
      AV50TFSedeDireccion_Sel = "" ;
      AV49TFSedeDireccion = "" ;
      AV52TFSedeCorreo_Sel = "" ;
      AV51TFSedeCorreo = "" ;
      AV54TFSedeEstado_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55TFSedeEstado_Sel = "" ;
      AV57TFSedeTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58TFSedeTipo_Sel = "" ;
      AV60TFSedeSector_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_exceldoc4 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int5 = new short[1] ;
      AV61TFSedeSector_Sel = "" ;
      AV20Session = httpContext.getWebSession();
      AV27ColumnsSelectorXML = "" ;
      AV24ColumnsSelector = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      AV26ColumnsSelector_Column = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector_Column(remoteHandle, context);
      A75SedeNombre = "" ;
      A116ClinicaNombreComercial = "" ;
      A44UbigeoCode = "" ;
      A185UbigeoNombre = "" ;
      A276SedeDireccion = "" ;
      A277SedeCorreo = "" ;
      A278SedeEstado = "" ;
      A279SedeTipo = "" ;
      A280SedeSector = "" ;
      AV71Sedewwds_1_filterfulltext = "" ;
      AV74Sedewwds_4_tfsedenombre = "" ;
      AV75Sedewwds_5_tfsedenombre_sel = "" ;
      AV80Sedewwds_10_tfclinicanombrecomercial = "" ;
      AV81Sedewwds_11_tfclinicanombrecomercial_sel = "" ;
      AV82Sedewwds_12_tfubigeocode = "" ;
      AV83Sedewwds_13_tfubigeocode_sel = "" ;
      AV84Sedewwds_14_tfubigeonombre = "" ;
      AV85Sedewwds_15_tfubigeonombre_sel = "" ;
      AV86Sedewwds_16_tfsededireccion = "" ;
      AV87Sedewwds_17_tfsededireccion_sel = "" ;
      AV88Sedewwds_18_tfsedecorreo = "" ;
      AV89Sedewwds_19_tfsedecorreo_sel = "" ;
      AV90Sedewwds_20_tfsedeestado_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91Sedewwds_21_tfsedetipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV92Sedewwds_22_tfsedesector_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      lV71Sedewwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV74Sedewwds_4_tfsedenombre = "" ;
      lV80Sedewwds_10_tfclinicanombrecomercial = "" ;
      lV82Sedewwds_12_tfubigeocode = "" ;
      lV84Sedewwds_14_tfubigeonombre = "" ;
      lV86Sedewwds_16_tfsededireccion = "" ;
      lV88Sedewwds_18_tfsedecorreo = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      P004B2_A118ClinicaRUC = new long[1] ;
      P004B2_A28ClinicaId = new short[1] ;
      P004B2_A30SedeId = new short[1] ;
      P004B2_A280SedeSector = new String[] {""} ;
      P004B2_A279SedeTipo = new String[] {""} ;
      P004B2_A278SedeEstado = new String[] {""} ;
      P004B2_A277SedeCorreo = new String[] {""} ;
      P004B2_A276SedeDireccion = new String[] {""} ;
      P004B2_A185UbigeoNombre = new String[] {""} ;
      P004B2_A44UbigeoCode = new String[] {""} ;
      P004B2_A116ClinicaNombreComercial = new String[] {""} ;
      P004B2_A75SedeNombre = new String[] {""} ;
      P004B2_A186UbigeoDepartamento = new String[] {""} ;
      P004B2_A187UbigeoProvincia = new String[] {""} ;
      P004B2_A188UbigeoDistrito = new String[] {""} ;
      AV28UserCustomValue = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV25ColumnsSelectorAux = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector(remoteHandle, context);
      GXv_SdtWWPColumnsSelector8 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      GXv_SdtWWPColumnsSelector9 = new com.projectthani.wwpbaseobjects.SdtWWPColumnsSelector[1] ;
      AV22GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV53TFSedeEstado_SelsJson = "" ;
      AV56TFSedeTipo_SelsJson = "" ;
      AV59TFSedeSector_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sedewwexport__default(),
         new Object[] {
             new Object[] {
            P004B2_A118ClinicaRUC, P004B2_A28ClinicaId, P004B2_A30SedeId, P004B2_A280SedeSector, P004B2_A279SedeTipo, P004B2_A278SedeEstado, P004B2_A277SedeCorreo, P004B2_A276SedeDireccion, P004B2_A185UbigeoNombre, P004B2_A44UbigeoCode,
            P004B2_A116ClinicaNombreComercial, P004B2_A75SedeNombre, P004B2_A186UbigeoDepartamento, P004B2_A187UbigeoProvincia, P004B2_A188UbigeoDistrito
            }
         }
      );
      AV65Pgmname = "SedeWWExport" ;
      /* GeneXus formulas. */
      AV65Pgmname = "SedeWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV35TFSedeId ;
   private short AV36TFSedeId_To ;
   private short AV39TFClinicaId ;
   private short AV40TFClinicaId_To ;
   private short GXv_int5[] ;
   private short A30SedeId ;
   private short A28ClinicaId ;
   private short AV72Sedewwds_2_tfsedeid ;
   private short AV73Sedewwds_3_tfsedeid_to ;
   private short AV76Sedewwds_6_tfclinicaid ;
   private short AV77Sedewwds_7_tfclinicaid_to ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV66GXV1 ;
   private int AV67GXV2 ;
   private int AV68GXV3 ;
   private int AV69GXV4 ;
   private int AV90Sedewwds_20_tfsedeestado_sels_size ;
   private int AV91Sedewwds_21_tfsedetipo_sels_size ;
   private int AV92Sedewwds_22_tfsedesector_sels_size ;
   private int AV93GXV5 ;
   private long AV41TFClinicaRUC ;
   private long AV42TFClinicaRUC_To ;
   private long AV62i ;
   private long AV32VisibleColumnCount ;
   private long A118ClinicaRUC ;
   private long AV78Sedewwds_8_tfclinicaruc ;
   private long AV79Sedewwds_9_tfclinicaruc_to ;
   private String AV65Pgmname ;
   private String AV46TFUbigeoCode_Sel ;
   private String AV45TFUbigeoCode ;
   private String AV55TFSedeEstado_Sel ;
   private String AV58TFSedeTipo_Sel ;
   private String AV61TFSedeSector_Sel ;
   private String A44UbigeoCode ;
   private String A278SedeEstado ;
   private String A279SedeTipo ;
   private String A280SedeSector ;
   private String AV82Sedewwds_12_tfubigeocode ;
   private String AV83Sedewwds_13_tfubigeocode_sel ;
   private String scmdbuf ;
   private String lV82Sedewwds_12_tfubigeocode ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV27ColumnsSelectorXML ;
   private String AV28UserCustomValue ;
   private String AV53TFSedeEstado_SelsJson ;
   private String AV56TFSedeTipo_SelsJson ;
   private String AV59TFSedeSector_SelsJson ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String AV38TFSedeNombre_Sel ;
   private String AV37TFSedeNombre ;
   private String AV44TFClinicaNombreComercial_Sel ;
   private String AV43TFClinicaNombreComercial ;
   private String AV48TFUbigeoNombre_Sel ;
   private String AV47TFUbigeoNombre ;
   private String AV50TFSedeDireccion_Sel ;
   private String AV49TFSedeDireccion ;
   private String AV52TFSedeCorreo_Sel ;
   private String AV51TFSedeCorreo ;
   private String A75SedeNombre ;
   private String A116ClinicaNombreComercial ;
   private String A185UbigeoNombre ;
   private String A276SedeDireccion ;
   private String A277SedeCorreo ;
   private String AV71Sedewwds_1_filterfulltext ;
   private String AV74Sedewwds_4_tfsedenombre ;
   private String AV75Sedewwds_5_tfsedenombre_sel ;
   private String AV80Sedewwds_10_tfclinicanombrecomercial ;
   private String AV81Sedewwds_11_tfclinicanombrecomercial_sel ;
   private String AV84Sedewwds_14_tfubigeonombre ;
   private String AV85Sedewwds_15_tfubigeonombre_sel ;
   private String AV86Sedewwds_16_tfsededireccion ;
   private String AV87Sedewwds_17_tfsededireccion_sel ;
   private String AV88Sedewwds_18_tfsedecorreo ;
   private String AV89Sedewwds_19_tfsedecorreo_sel ;
   private String lV71Sedewwds_1_filterfulltext ;
   private String lV74Sedewwds_4_tfsedenombre ;
   private String lV80Sedewwds_10_tfclinicanombrecomercial ;
   private String lV84Sedewwds_14_tfubigeonombre ;
   private String lV86Sedewwds_16_tfsededireccion ;
   private String lV88Sedewwds_18_tfsedecorreo ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private GXSimpleCollection<String> AV54TFSedeEstado_Sels ;
   private GXSimpleCollection<String> AV57TFSedeTipo_Sels ;
   private GXSimpleCollection<String> AV60TFSedeSector_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P004B2_A118ClinicaRUC ;
   private short[] P004B2_A28ClinicaId ;
   private short[] P004B2_A30SedeId ;
   private String[] P004B2_A280SedeSector ;
   private String[] P004B2_A279SedeTipo ;
   private String[] P004B2_A278SedeEstado ;
   private String[] P004B2_A277SedeCorreo ;
   private String[] P004B2_A276SedeDireccion ;
   private String[] P004B2_A185UbigeoNombre ;
   private String[] P004B2_A44UbigeoCode ;
   private String[] P004B2_A116ClinicaNombreComercial ;
   private String[] P004B2_A75SedeNombre ;
   private String[] P004B2_A186UbigeoDepartamento ;
   private String[] P004B2_A187UbigeoProvincia ;
   private String[] P004B2_A188UbigeoDistrito ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc4[] ;
   private GXSimpleCollection<String> AV90Sedewwds_20_tfsedeestado_sels ;
   private GXSimpleCollection<String> AV91Sedewwds_21_tfsedetipo_sels ;
   private GXSimpleCollection<String> AV92Sedewwds_22_tfsedesector_sels ;
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

final  class sedewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A278SedeEstado ,
                                          GXSimpleCollection<String> AV90Sedewwds_20_tfsedeestado_sels ,
                                          String A279SedeTipo ,
                                          GXSimpleCollection<String> AV91Sedewwds_21_tfsedetipo_sels ,
                                          String A280SedeSector ,
                                          GXSimpleCollection<String> AV92Sedewwds_22_tfsedesector_sels ,
                                          short AV72Sedewwds_2_tfsedeid ,
                                          short AV73Sedewwds_3_tfsedeid_to ,
                                          String AV75Sedewwds_5_tfsedenombre_sel ,
                                          String AV74Sedewwds_4_tfsedenombre ,
                                          short AV76Sedewwds_6_tfclinicaid ,
                                          short AV77Sedewwds_7_tfclinicaid_to ,
                                          long AV78Sedewwds_8_tfclinicaruc ,
                                          long AV79Sedewwds_9_tfclinicaruc_to ,
                                          String AV81Sedewwds_11_tfclinicanombrecomercial_sel ,
                                          String AV80Sedewwds_10_tfclinicanombrecomercial ,
                                          String AV83Sedewwds_13_tfubigeocode_sel ,
                                          String AV82Sedewwds_12_tfubigeocode ,
                                          String AV85Sedewwds_15_tfubigeonombre_sel ,
                                          String AV84Sedewwds_14_tfubigeonombre ,
                                          String AV87Sedewwds_17_tfsededireccion_sel ,
                                          String AV86Sedewwds_16_tfsededireccion ,
                                          String AV89Sedewwds_19_tfsedecorreo_sel ,
                                          String AV88Sedewwds_18_tfsedecorreo ,
                                          int AV90Sedewwds_20_tfsedeestado_sels_size ,
                                          int AV91Sedewwds_21_tfsedetipo_sels_size ,
                                          int AV92Sedewwds_22_tfsedesector_sels_size ,
                                          short A30SedeId ,
                                          String A75SedeNombre ,
                                          short A28ClinicaId ,
                                          long A118ClinicaRUC ,
                                          String A116ClinicaNombreComercial ,
                                          String A44UbigeoCode ,
                                          String A186UbigeoDepartamento ,
                                          String A187UbigeoProvincia ,
                                          String A188UbigeoDistrito ,
                                          String A276SedeDireccion ,
                                          String A277SedeCorreo ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc ,
                                          String AV71Sedewwds_1_filterfulltext ,
                                          String A185UbigeoNombre )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[38];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT T2.[ClinicaRUC], T1.[ClinicaId], T1.[SedeId], T1.[SedeSector], T1.[SedeTipo], T1.[SedeEstado], T1.[SedeCorreo], T1.[SedeDireccion], T3.[UbigeoDepartamento]" ;
      scmdbuf += " + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] AS UbigeoNombre, T1.[UbigeoCode], T2.[ClinicaNombreComercial], T1.[SedeNombre], T3.[UbigeoDepartamento]," ;
      scmdbuf += " T3.[UbigeoProvincia], T3.[UbigeoDistrito] FROM (([Sede] T1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = T1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode]" ;
      scmdbuf += " = T1.[UbigeoCode])" ;
      addWhere(sWhereString, "((? = '') or ( ( CONVERT( char(4), CAST(T1.[SedeId] AS decimal(4,0))) like '%' + ?) or ( T1.[SedeNombre] like '%' + ?) or ( CONVERT( char(4), CAST(T1.[ClinicaId] AS decimal(4,0))) like '%' + ?) or ( CONVERT( char(11), CAST(T2.[ClinicaRUC] AS decimal(11,0))) like '%' + ?) or ( T2.[ClinicaNombreComercial] like '%' + ?) or ( T1.[UbigeoCode] like '%' + ?) or ( T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like '%' + ?) or ( T1.[SedeDireccion] like '%' + ?) or ( T1.[SedeCorreo] like '%' + ?) or ( 'activo' like '%' + LOWER(?) and T1.[SedeEstado] = 'A') or ( 'inactivo' like '%' + LOWER(?) and T1.[SedeEstado] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeTipo] = '')) or ( 'hospital' like '%' + LOWER(?) and T1.[SedeTipo] = 'H') or ( 'clínica' like '%' + LOWER(?) and T1.[SedeTipo] = 'C') or ( 'policlínico' like '%' + LOWER(?) and T1.[SedeTipo] = 'P') or ( 'independiente' like '%' + LOWER(?) and T1.[SedeTipo] = 'I') or ( 'seleccione' like '%' + LOWER(?) and (T1.[SedeSector] = '')) or ( 'publico' like '%' + LOWER(?) and T1.[SedeSector] = 'P') or ( 'privado' like '%' + LOWER(?) and T1.[SedeSector] = 'V')))");
      if ( ! (0==AV72Sedewwds_2_tfsedeid) )
      {
         addWhere(sWhereString, "(T1.[SedeId] >= ?)");
      }
      else
      {
         GXv_int10[20] = (byte)(1) ;
      }
      if ( ! (0==AV73Sedewwds_3_tfsedeid_to) )
      {
         addWhere(sWhereString, "(T1.[SedeId] <= ?)");
      }
      else
      {
         GXv_int10[21] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV75Sedewwds_5_tfsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV74Sedewwds_4_tfsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int10[22] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV75Sedewwds_5_tfsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int10[23] = (byte)(1) ;
      }
      if ( ! (0==AV76Sedewwds_6_tfclinicaid) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] >= ?)");
      }
      else
      {
         GXv_int10[24] = (byte)(1) ;
      }
      if ( ! (0==AV77Sedewwds_7_tfclinicaid_to) )
      {
         addWhere(sWhereString, "(T1.[ClinicaId] <= ?)");
      }
      else
      {
         GXv_int10[25] = (byte)(1) ;
      }
      if ( ! (0==AV78Sedewwds_8_tfclinicaruc) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] >= ?)");
      }
      else
      {
         GXv_int10[26] = (byte)(1) ;
      }
      if ( ! (0==AV79Sedewwds_9_tfclinicaruc_to) )
      {
         addWhere(sWhereString, "(T2.[ClinicaRUC] <= ?)");
      }
      else
      {
         GXv_int10[27] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV81Sedewwds_11_tfclinicanombrecomercial_sel)==0) && ( ! (GXutil.strcmp("", AV80Sedewwds_10_tfclinicanombrecomercial)==0) ) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] like ?)");
      }
      else
      {
         GXv_int10[28] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV81Sedewwds_11_tfclinicanombrecomercial_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[ClinicaNombreComercial] = ?)");
      }
      else
      {
         GXv_int10[29] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV83Sedewwds_13_tfubigeocode_sel)==0) && ( ! (GXutil.strcmp("", AV82Sedewwds_12_tfubigeocode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] like ?)");
      }
      else
      {
         GXv_int10[30] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV83Sedewwds_13_tfubigeocode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[UbigeoCode] = ?)");
      }
      else
      {
         GXv_int10[31] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV85Sedewwds_15_tfubigeonombre_sel)==0) && ( ! (GXutil.strcmp("", AV84Sedewwds_14_tfubigeonombre)==0) ) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] like ?)");
      }
      else
      {
         GXv_int10[32] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV85Sedewwds_15_tfubigeonombre_sel)==0) )
      {
         addWhere(sWhereString, "(T3.[UbigeoDepartamento] + ' / ' + T3.[UbigeoProvincia] + ' / ' + T3.[UbigeoDistrito] = ?)");
      }
      else
      {
         GXv_int10[33] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV87Sedewwds_17_tfsededireccion_sel)==0) && ( ! (GXutil.strcmp("", AV86Sedewwds_16_tfsededireccion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] like ?)");
      }
      else
      {
         GXv_int10[34] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV87Sedewwds_17_tfsededireccion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeDireccion] = ?)");
      }
      else
      {
         GXv_int10[35] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV89Sedewwds_19_tfsedecorreo_sel)==0) && ( ! (GXutil.strcmp("", AV88Sedewwds_18_tfsedecorreo)==0) ) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] like ?)");
      }
      else
      {
         GXv_int10[36] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV89Sedewwds_19_tfsedecorreo_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[SedeCorreo] = ?)");
      }
      else
      {
         GXv_int10[37] = (byte)(1) ;
      }
      if ( AV90Sedewwds_20_tfsedeestado_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV90Sedewwds_20_tfsedeestado_sels, "T1.[SedeEstado] IN (", ")")+")");
      }
      if ( AV91Sedewwds_21_tfsedetipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV91Sedewwds_21_tfsedetipo_sels, "T1.[SedeTipo] IN (", ")")+")");
      }
      if ( AV92Sedewwds_22_tfsedesector_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV92Sedewwds_22_tfsedesector_sels, "T1.[SedeSector] IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeNombre]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeId]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClinicaId]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClinicaId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ClinicaRUC]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ClinicaRUC] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[ClinicaNombreComercial]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[ClinicaNombreComercial] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[UbigeoCode] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeDireccion]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeDireccion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeCorreo]" ;
      }
      else if ( ( AV17OrderedBy == 8 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeCorreo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeEstado]" ;
      }
      else if ( ( AV17OrderedBy == 9 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeEstado] DESC" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeTipo]" ;
      }
      else if ( ( AV17OrderedBy == 10 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeTipo] DESC" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[SedeSector]" ;
      }
      else if ( ( AV17OrderedBy == 11 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[SedeSector] DESC" ;
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
                  return conditional_P004B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).longValue() , ((Number) dynConstraints[13]).longValue() , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (String)dynConstraints[17] , (String)dynConstraints[18] , (String)dynConstraints[19] , (String)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , ((Number) dynConstraints[26]).intValue() , ((Number) dynConstraints[27]).shortValue() , (String)dynConstraints[28] , ((Number) dynConstraints[29]).shortValue() , ((Number) dynConstraints[30]).longValue() , (String)dynConstraints[31] , (String)dynConstraints[32] , (String)dynConstraints[33] , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , ((Boolean) dynConstraints[39]).booleanValue() , (String)dynConstraints[40] , (String)dynConstraints[41] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getVarchar(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
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
                  stmt.setVarchar(sIdx, (String)parms[38], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[39], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[40], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[41], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[42], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[43], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[58]).shortValue());
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[59]).shortValue());
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 80);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 80);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[62]).shortValue());
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[63]).shortValue());
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[64]).longValue());
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[65]).longValue());
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[68], 10);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[69], 10);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               return;
      }
   }

}


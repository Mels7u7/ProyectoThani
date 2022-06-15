package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setwwpcontext extends GXProcedure
{
   public setwwpcontext( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setwwpcontext.class ), "" );
   }

   public setwwpcontext( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( com.projectthani.wwpbaseobjects.SdtWWPContext aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.projectthani.wwpbaseobjects.SdtWWPContext aP0 )
   {
      setwwpcontext.this.AV8Context = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Session.setValue("wwpcontext", AV8Context.toxml(false, true, "WWPContext", "ProjectThani"));
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Session = httpContext.getWebSession();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private com.genexus.webpanels.WebSession AV9Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8Context ;
}


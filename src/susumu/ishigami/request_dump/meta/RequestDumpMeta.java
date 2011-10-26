package susumu.ishigami.request_dump.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-10-23 16:27:44")
/** */
public final class RequestDumpMeta extends org.slim3.datastore.ModelMeta<susumu.ishigami.request_dump.model.RequestDump> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, java.util.Date> createdAt = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, java.util.Date>(this, "createdAt", "createdAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump> headers = new org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump>(this, "headers", "headers");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump> parameters = new org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump>(this, "parameters", "parameters");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, java.lang.Integer> port = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, java.lang.Integer>(this, "port", "port", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<susumu.ishigami.request_dump.model.RequestDump> remoteHost = new org.slim3.datastore.StringAttributeMeta<susumu.ishigami.request_dump.model.RequestDump>(this, "remoteHost", "remoteHost");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump> requestDump = new org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump>(this, "requestDump", "requestDump");

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump> requestUri = new org.slim3.datastore.StringUnindexedAttributeMeta<susumu.ishigami.request_dump.model.RequestDump>(this, "requestUri", "requestUri");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<susumu.ishigami.request_dump.model.RequestDump, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final RequestDumpMeta slim3_singleton = new RequestDumpMeta();

    /**
     * @return the singleton
     */
    public static RequestDumpMeta get() {
       return slim3_singleton;
    }

    /** */
    public RequestDumpMeta() {
        super("RequestDump", susumu.ishigami.request_dump.model.RequestDump.class);
    }

    @Override
    public susumu.ishigami.request_dump.model.RequestDump entityToModel(com.google.appengine.api.datastore.Entity entity) {
        susumu.ishigami.request_dump.model.RequestDump model = new susumu.ishigami.request_dump.model.RequestDump();
        model.setCreatedAt((java.util.Date) entity.getProperty("createdAt"));
        model.setHeaders(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("headers")));
        model.setKey(entity.getKey());
        model.setParameters(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("parameters")));
        model.setPort(longToPrimitiveInt((java.lang.Long) entity.getProperty("port")));
        model.setRemoteHost((java.lang.String) entity.getProperty("remoteHost"));
        model.setRequestDump(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("requestDump")));
        model.setRequestUri(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("requestUri")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        susumu.ishigami.request_dump.model.RequestDump m = (susumu.ishigami.request_dump.model.RequestDump) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createdAt", m.getCreatedAt());
        entity.setUnindexedProperty("headers", stringToText(m.getHeaders()));
        entity.setUnindexedProperty("parameters", stringToText(m.getParameters()));
        entity.setProperty("port", m.getPort());
        entity.setProperty("remoteHost", m.getRemoteHost());
        entity.setUnindexedProperty("requestDump", stringToText(m.getRequestDump()));
        entity.setUnindexedProperty("requestUri", stringToText(m.getRequestUri()));
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        susumu.ishigami.request_dump.model.RequestDump m = (susumu.ishigami.request_dump.model.RequestDump) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        susumu.ishigami.request_dump.model.RequestDump m = (susumu.ishigami.request_dump.model.RequestDump) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        susumu.ishigami.request_dump.model.RequestDump m = (susumu.ishigami.request_dump.model.RequestDump) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void incrementVersion(Object model) {
        susumu.ishigami.request_dump.model.RequestDump m = (susumu.ishigami.request_dump.model.RequestDump) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
        assignKeyIfNecessary(model);
        incrementVersion(model);
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

}
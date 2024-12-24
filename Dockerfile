FROM opensearchproject/opensearch:2.11.0 as build
RUN /usr/share/opensearch/bin/opensearch-plugin install analysis-phonetic
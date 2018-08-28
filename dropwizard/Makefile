DOCKERUSER?=sigsci
DOCKERNAME?=sigsci-dropwizard
DOCKERTAG?=latest
SIGSCI_HOSTNAME?=dropwizard
EXPOSE_PORT?=4000
AGENT_CONF?=$(shell pwd)/agent.conf

build:
	docker build -t $(DOCKERUSER)/$(DOCKERNAME):$(DOCKERTAG) .

build-no-cache:
	docker build --no-cache -t $(DOCKERUSER)/$(DOCKERNAME):$(DOCKERTAG) .

run:
	docker run -i -v $(AGENT_CONF):/etc/sigsci/agent.conf --name $(DOCKERNAME) --hostname $(SIGSCI_HOSTNAME) -p $(EXPOSE_PORT):8080 -d $(DOCKERUSER)/$(DOCKERNAME)

deploy:
	docker push $(DOCKERUSER)/$(DOCKERNAME):$(DOCKERTAG)

stop:
	docker stop $(DOCKERNAME)

clean:
	-docker kill $(DOCKERNAME)
	-docker rm $(DOCKERNAME)

destroy:
	-docker kill $(DOCKERNAME)
	-docker rm $(DOCKERNAME)
	-docker rmi $(DOCKERUSER)/$(DOCKERNAME):$(DOCKERTAG)

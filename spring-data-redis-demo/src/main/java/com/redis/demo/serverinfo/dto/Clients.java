package com.redis.demo.serverinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients {

	private int connectedClients;
	private int clusterConnections;
	private int maxClients;
	private int clientRecentMaxInputBuffer;
	private int clientRecentMaxOutputBuffer;
	private int blockedClients;
	private int trackingClients;
	private int clientsInTimeoutTable;
}

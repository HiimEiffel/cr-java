package royaleserver.network.protocol.client.commands;

import royaleserver.network.protocol.Commands;
import royaleserver.network.protocol.client.ClientCommand;
import royaleserver.network.protocol.client.ClientCommandHandler;
import royaleserver.utils.DataStream;

public class ChestFreeOpen extends ClientCommand {
	public static final short ID = Commands.CHEST_FREE_OPEN;

	public int tickStart;
	public int tickEnd;

	public int unknown_2, unknown_3;

	public int selection;

	public ChestFreeOpen() {
		super(ID);
	}

	@Override
	public ClientCommand create() {
		return new ChestFreeOpen();
	}

	@Override
	public boolean handle(ClientCommandHandler handler) throws Throwable {
		return handler.handleChestFreeOpen(this);
	}

	@Override
	public void decode(DataStream stream) {
		tickStart = stream.getRrsInt32();
		tickEnd = stream.getRrsInt32();

		unknown_2 = stream.getRrsInt32(); // Always 00
		unknown_3 = stream.getRrsInt32(); // Always 01
	}
}

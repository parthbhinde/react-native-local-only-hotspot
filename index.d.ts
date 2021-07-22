declare namespace LocalOnlyHotspot {
  function start(
    onSuccess: (config: Config) => void,
    onFailure: (reason: number) => void
  ): void;
  function stop(onStop: (message: string) => void): void;
  function getConfig(onData: (config: Partial<Config>) => void): void;
}

export type Config = {
  ssid: string;
  secret: string;
};

export default LocalOnlyHotspot;

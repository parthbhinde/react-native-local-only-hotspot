declare namespace LocalOnlyHotspot {
  function start(
    onSuccess: (config: { ssid: string; secret: string }) => void,
    onFailure: (reason: number) => void
  ): void;
  function stop(onStop: (message: string) => void): void;
  function getConfig(
    onData: (config: { ssid: string; secret: string }) => void
  ): void;
}

export default LocalOnlyHotspot;

package com.zennyel.ogsmpclasses.manager;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

    public class ThreadManager {

        private static Plugin plugin;
        private static BukkitScheduler scheduler;

        public static void initialize(Plugin plugin) {
            ThreadManager.plugin = plugin;
            ThreadManager.scheduler = plugin.getServer().getScheduler();
        }

        public static void runAsync(Runnable task) {
            scheduler.runTaskAsynchronously(plugin, task);
        }

        public static void runSync(Runnable task) {
            scheduler.runTask(plugin, task);
        }

        public static void runAsyncLater(Runnable task, long delayTicks) {
            scheduler.runTaskLaterAsynchronously(plugin, task, delayTicks);
        }

        public static void runSyncLater(Runnable task, long delayTicks) {
            scheduler.runTaskLater(plugin, task, delayTicks);
        }

        public static void runAsyncTimer(Runnable task, long delayTicks, long periodTicks) {
            scheduler.runTaskTimerAsynchronously(plugin, task, delayTicks, periodTicks);
        }

        public static void runSyncTimer(Runnable task, long delayTicks, long periodTicks) {
            scheduler.runTaskTimer(plugin, task, delayTicks, periodTicks);
        }

        public static void cancelTasks() {
            scheduler.cancelTasks(plugin);
        }
    }


